## What is this tool about? 
To analyze the activities of an Android application and figure out the activity-permission mapping, activity mapping, services listing, activity listing, and protection level detection for permission tags. We also wanted to give the user a simple UI to showcase the analyzed results so that they can make better decisions regarding the application.

The decompilation is performed by jadx and the files are stored on the server on which the tool runs in real-time to analyze the permission tags.

## To access the tool online [http://18.191.126.212:8080/app/select](http://18.191.126.212:8080/app/select)

To run the tool on your computer, make sure you have atleast Python 3.6 and Django installed

The basic Django folder structure is utilized, The apps, templates and urls.py are all put in the standard formatting structure

Make sure you decompile the android application you'd like to run the tool on through jadx and place the folder in the ./DecompiledFiles 

The analysis is based on two important studies namely PScout(https://doi.org/10.1145/2382196.2382222) and ASplorer (https://dl.acm.org/doi/10.5555/3241094.3241180)