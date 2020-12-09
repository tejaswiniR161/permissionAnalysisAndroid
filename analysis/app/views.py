from django.shortcuts import render
from django.http import HttpResponse
import os
import xml.dom.minidom
import xml.etree.ElementTree as ET

AXplore = open('./Permissions/Axplore_Permission.txt', 'r') 
AXploreLines = AXplore.readlines() 
PScout = open('./Permissions/PScout_Permission.txt', 'r') 
PScoutLines = PScout.readlines() 

listOfPermissions=[]
listOfCustomPermissions=[]
protectionLevelForCustomPermissions=[]
listOfServices=[]
listOfActivities=[]
listOfReceivers=[]
activityMapping={}
activityPermissions={}
functionsBasedOnPermissionMappingInitial={}
relativeDecompiledPath=""
unopenableActivityJava=[]
openableActivityJava=[]
AppName="EarSpy_source_from_JADX"

def index(request):
    print("cwd = ",os.getcwd())
    #MODIFY_PHONE_STATE
    ans=read_and_map("CAMERA")
    parse_manifest()
    gather_permissions_per_activity()
    return render(request,'index.html',{"ans":listOfActivities})

def gather_permissions_per_activity():
    collection=[]
    global relativeDecompiledPath
    sourcesPath=relativeDecompiledPath+"/sources/"
    realFileName=""
    relativeFilePath=""

    #print("sources path = ",sourcesPath)

    for activity in listOfActivities:
        initialpath=activity.split(".")
        realFileName=initialpath[len(initialpath)-1]
        realFileName+=".java"
        print("real file name = ",realFileName)
        transformedPath="/".join(initialpath)
        filePath=sourcesPath+transformedPath
        #if os.path.exists(os.path.join(os.getcwd(), 'new_folder', 'file.txt'))
        #if os.path.exists(filePath):
            #print("Folder exists! Moving on")
        #else:
            #print("Direct path the split way does not exist! So, using the better way to do it I guess?")
        for x in os.walk(sourcesPath):
            #print("\n x = ",x)
            if realFileName in x[2]:
                #print("Found it! ")
                relativeFilePath=x[0]+"/"+realFileName
                print("File path = ",relativeFilePath)
                collection.append(relativeFilePath)
                break
        try:
            currentFile=open(relativeFilePath)
            content=currentFile.readlines()
            openableActivityJava.append(filePath)
        except Exception as e:
            print("List of unopenable activity java files ++ ",e)
            unopenableActivityJava.append(filePath)

    if len(collection)<len(listOfActivities):
        print("Not all files were found! ")
        print("There are missing files and count = ",len(listOfActivities)-len(collection))

        
    #print("openable files = ",openableActivityJava)
    #print("not able to open = ",unopenableActivityJava) 
    #./DecompiledFiles/EarSpy_source_from_JADX/sources/com/microphone/earspy/SplashScree

        

def parse_manifest():
    DecompiledPath="DecompiledFiles"
    for dirs in os.listdir(DecompiledPath):
        #if not (dirs.endswith(".zip") or dirs.endswith(".DS_Store")):
            #print("This Folder was found",dirs)
        if AppName.find(dirs)!=-1:
            print("Folder found with the app name") 
            manifestPath=os.path.join("./"+DecompiledPath,dirs)
            print("Manifest path = ",manifestPath)
            global relativeDecompiledPath
            relativeDecompiledPath=manifestPath
            try:
                manifestFile=open(manifestPath+"/resources/AndroidManifest.xml")
                manifestFile.close()
                parser(manifestPath+"/resources/AndroidManifest.xml")
                #if(len(manifestLines)>5):

                #print("Content in here reading")
                #print("permission tags gotten so far = ",listOfPermissions,listOfCustomPermissions,protectionLevelForCustomPermissions)

                for i in listOfPermissions:
                    functionsBasedOnPermissionMappingInitial[i]=read_and_map(i)
                
                #else:
                    #print("Not much of content found so decompilation issues")
                    #raise Exception("Content length too small")
            except Exception as e:
                print("Manifest file was not found! Sorry! Try a different application \n",str(e))
                print("relative path was = analysis/DecompiledFiles/EarSpy_source_from_JADX/resources/AndroidManifest.xml")

def parser(filename):
    doc = xml.dom.minidom.parse(filename)
    tree = ET.parse(filename)
    root = tree.getroot()
    name = root.get("package")
    #print("name = ",name)
    androidPermissions = doc.getElementsByTagName("uses-permission")
    customPermissions = doc.getElementsByTagName("permission")
    activities = doc.getElementsByTagName("activity")
    for permission in androidPermissions:
        #print(permission.getAttribute("android:name"))
        listOfPermissions.append(permission.getAttribute("android:name"))
    for permission in customPermissions:
        #print(permission.getAttribute("android:name"))
        #print(permission.getAttribute("android:protectionLevel"))
        listOfCustomPermissions.append(permission.getAttribute("android:name"))
        protectionLevelForCustomPermissions.append(permission.getAttribute("android:protectionLevel"))
    for activity in activities:
        listOfActivities.append(activity.getAttribute("android:name"))
        #print(activity.getAttribute("android:name"))
        #print(str(activity))
        intent_filter=activity.getElementsByTagName("intent-filter")
        curr_list=[]
        if len(intent_filter)>=1:
            for intent in intent_filter:
                action=intent.getElementsByTagName("action")[0]
                category=intent.getElementsByTagName("category")[0]
                #print("action = ",action.getAttribute("android:name"))
                #print("category = ",category)
                curr_list.append({"action":action.getAttribute("android:name"),"category":category.getAttribute("android:name")})
            #print("intent-filter = ",intent_filter)
            activityMapping[activity.getAttribute("android:name")]=curr_list
            
            """
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
            """
        #for a in activity:
            #print("a = ",a)
        #print(activity.getAttribute("intent-filter"))


def read_and_map(perm):
    #print("Read and Map triggered : Fetching the list of function names")
    ans=[]
    t=""
    for l in AXploreLines:
        #print("atleast here?",l)
        s=l.split("::")
        if s[1].find(perm)!=-1:
            #print("here?")
            t=s[0].split("(")
            ans.append(t[0])
    append_to_ans=False
    for l in PScoutLines:
        if l.find("Permission:")!=-1 and l.find(perm)!=-1:
            append_to_ans=True
            #print("initialted?")
        elif l.find("Permission:")!=-1 and l.find(perm)==-1:
            #print("resetting")
            append_to_ans=False
        
        if append_to_ans==True and l.find("Callers")==-1 and l.find("Permission:"):
            #print("idya?")
            if l.find("<init>")==-1:
                t=l[l.find("<")+1:l.find(">")]
            else:
                #parse again
                t=l[l.find("<")+1:l.find(")>")]
            if len(t)>1:
                h=t.split(": ")
                #print("h = ",h)
                k=h[1].split(" ")
                f=h[0]+"."+k[1]+k[0]
                if f not in ans:
                    tf=f.split("(")
                    tf=tf[0]
                    ans.append(tf)     
    return ans