#  MICE

## Project goals

This project focuses on creating showcase of how author techniques like MICE can lead to procedural consistency within an interactive narrative.


## Abstract

MICE in the Machine focuses on interactively generating narratives through a reactive planner that uses plotting techniques. Unlike other story planners, this demo uses an authoring technique called MICE, which is an organizational process that professional authors use. MICE decomposes narratives into four possible compositional arcs or "threads": Milieu, Inquiry, Character, and Event. These story threads are plot arcs, explaining how plots should start and close. They show the author what expectations the audience may have, how to resolve those expectations, and if there are open plotlines.  While MICE is one example of authoring techniques, it is the first to be used in a computational model of reactive storytelling. The demo features a computational model of MICE implemented in the ABL reactive planning language to evaluate the model of MICE as a procedural story generator. This work is the first step towards a more comprehensive AI system that interactively generates storylines during gameplay.

## Release Link

AIIDE Demo: [the link]()

## Instructions for Pre-Built Version

1. Please install the latest version of the [Java JDK](https://www.oracle.com/java/technologies/downloads/) from Orcale. (This will be needed to run the jar file for this demo.)
2. Once Java is installed, please navigate, within a console environment, to <user_path>\MICE\ABL\ACU-agent\Build. This is where the runnable jar file of the ABL agent is located.
3. To run the jar file, please type: `java -jar MICE.jar` 
    * This should start a server witin your console environment. 

4. Now, through a file explorer, navigate to <user_path>\MICE\Unity\Build where two different build paths are provided: Windows and Mac. 
5. Please choose the one for your operating system and run the executable. The demo should start, and it should communicate with the java server.

## Instructions to Build and Run from Source
1. Install [Eclipse](https://www.eclipse.org/) or any Java IDE. We used the 2021-12 version.
2. Install Unity version 2021.3.3f1 from either Unity Hub or the [archives](https://unity3d.com/get-unity/download/archive) 
3. Install [Ink-Unity-Integration](https://github.com/inkle/ink-unity-integration) through the Unity asset store. 

### Installation

1. Clone this repositroy: 

`git clone git@github.com:singlab/MICE.git`

2. In Eclipse, click on the File dropdown menu, and select import. From there, select the General folder and choose File System.


3. Select the rool directory to be <user_path>\MICEABL\ABU-agent, where <user_path> is the user's relative directory. Select the ACU-agent project when it populates within the Projects textarea.

4. Eclipse should open the project, and now navigate to the StoryRunner.java file, which is in ACU-agent>src>Runner 

5. Run the StoryRunner.java file through Eclipse. Debug statements should appear within the console. The server should now be running.

6. Now, you can choose either to download Unity and open the MICE Unity project, or simple use the pre-built demo within Unity\Build.


### Known Bugs
Occasionally, ink text will not appear on certain scenes, such as the scene right after procedurally switching story points with ABL. 

### Video Explanation.
Here is an run through and explanation of the demo in video form. https://youtu.be/VnR7eesR_qI
