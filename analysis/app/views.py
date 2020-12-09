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
functionsBasedOnPermissionMappingInitial={}

AppName="EarSpy_source_from_JADX"

def index(request):
    print("cwd = ",os.getcwd())
    #MODIFY_PHONE_STATE
    ans=read_and_map("CAMERA")
    parse_manifest()
    return render(request,'index.html',{"ans":ans})

def parse_manifest():
    DecompiledPath="DecompiledFiles"
    for dirs in os.listdir(DecompiledPath):
        #if not (dirs.endswith(".zip") or dirs.endswith(".DS_Store")):
            #print("This Folder was found",dirs)
        if AppName.find(dirs)!=-1:
            print("Folder found with the app name") 
            manifestPath=os.path.join("./"+DecompiledPath,dirs)
            print("Manifest path = ",manifestPath)
            try:
                manifestFile=open(manifestPath+"/resources/AndroidManifest.xml")
                manifestFile.close()
                parser(manifestPath+"/resources/AndroidManifest.xml")
                #if(len(manifestLines)>5):
                print("Content in here reading")
                print("permission tags gotten so far = ",listOfPermissions,listOfCustomPermissions,protectionLevelForCustomPermissions)
                #else:
                    #print("Not much of content found so decompilation issues")
                    #raise Exception("Content length too small")
            except Exception as e:
                print("Manifest file was not found! Sorry! Try a different application \n",str(e))
                print("relative path was = analysis/DecompiledFiles/EarSpy_source_from_JADX/resources/AndroidManifest.xml")

def parser(filename):
    count = 0
    display = ""
    name = ""
    doc = xml.dom.minidom.parse(filename)
    tree = ET.parse(filename)
    root = tree.getroot()
    name = root.get("package")
    print("name = ",name)
    androidPermissions = doc.getElementsByTagName("uses-permission")
    customPermissions = doc.getElementsByTagName("permission")
    for permission in androidPermissions:
        #print(permission.getAttribute("android:name"))
        listOfPermissions.append(permission.getAttribute("android:name"))
    for permission in customPermissions:
        #print(permission.getAttribute("android:name"))
        #print(permission.getAttribute("android:protectionLevel"))
        listOfCustomPermissions.append(permission.getAttribute("android:name"))
        protectionLevelForCustomPermissions.append(permission.getAttribute("android:protectionLevel"))


def read_and_map(perm):
    print("Read and Map triggered : Fetching the list of function names")
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