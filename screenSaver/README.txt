
Screen saver uses a bare bones javafx media player (undecorated window, not controls)
to simulate a screensaver scene that uses a video of your choice. It will play the
video indefinetly unless you press the ALT key. 

There are two parts that have to be done in order for this script to work as intended.
  - First; the code has to be compiled:
    > This requires that you have the javaFx library installed. The code  was
      originally used with javafx-sdk-18.0.2.
    > This code was developed under the following java circumstances:
      * openjdk 11.0.16 2022-07-19
      * OpenJDK Runtime Environment (build 11.0.16+8-post-Debian-1deb11u1)
      
  - Second; files need to be moved to a binaries folder:
    > The compiling command given in the next section puts the compiled java code
      into a directory named "screensaver". The Shell script has
      to be moved inside that folder too. It will also make things easier if you move
      your target video into that directory as well.
    > Next you will have to add the screensaver directory to your $PATH variable
      so that you can use it as intended. However, before you do this you should
      consider moving the directory to your binaries folder to keep things
      better organized. 
    
Is is important to note that the script will only work after the files will have been moved to the binaries folder. 

1. To compile (into a directory called screensaver): 

   javac  -d screensaver  *.java --module-path /path/to/javafxlib --add-modules javafx.fxml,javafx.controls,javafx.graphics,javafx.media

   - At this point, you can run the program with the following command after you cd into the output directory named "screensaver".

     java  --module-path /path/to/javafxlib --add-modules javafx.fxml,javafx.controls,javafx.graphics,javafx.media -cp . screenSaver <video name or video path> 

     > However, this is not very practical, that is where the shell script comes in handy. 

2. In order to be able to run the script from anywhere it is important that you change
   the file permissions accordingly and that your $PATH variable points towards the
   working directory where the files are located. 

There are three things to note about the shell script:

1. the "videoName" variable within the script (line 3) has to be changed to reflect the name of the video
   that you want to use. If the video you want to use is in an entirely different
   directory, you will have to change the "videoNamePath" (line 16)  variable to reflect
   the path to your video.

2. As the script stands it assumes that the $javaFx (line 19) variable points to the
   javafx library within your system i.e. it is a path variable saved in your .bashrc file or equivalent.
   you can choose to remove this and instead hardcode the path to the library.

3. you can rename the shell script however you want. Since this is the command that you will be using
   it is only logical that you can call it whatever you want. Do not rename the .java or .class files
   if you are not comfortable with the way java works, if you do only do so at your own risk. 
   

