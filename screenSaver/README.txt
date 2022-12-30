
Screen saver uses a bare bones javafx media player (undecorated window, not controls)
to simulate a screensaver scene that uses a video of your choice. It will play the
video indefinetly unless you press the ALT key. 

There are two parts that have to be done in order for this script to work as intended.
  - First;
    > This requires that you have the javaFx library installed. The code  was
      tested with javafx-sdk-18.0.2.
    
    > This code was developed under the following java circumstances:
      * openjdk 11.0.16 2022-07-19
      * OpenJDK Runtime Environment (build 11.0.16+8-post-Debian-1deb11u1)
      
    > The code has to be compiled ( if using the compile script ):
      * You can use the included "compile" script. It requires the path to the
      	video you wish to use.
      * It assumes that you have a system variable as $javaFx that points to the
      	javaFx library in your system.
	
    > If you want to compile everything manually:
      * First make a directory called screensaver.
      * Compile the jave code using:   
         javac  -d screensaver  *.java --module-path /path/to/javafxlib --add-modules javafx.fxml,javafx.controls,javafx.graphics,javafx.media
      * Move the script to the screensaver directory. 
        1. The "videoName" variable within the script (line 3) has to be changed to reflect the name of the video
	that you want to use. If the video you want to use is in an entirely different
	directory, you will have to change the "videoNamePath" (line 16)  variable to reflect
	the path to your video.
        
  - Second:
    > In order to be able to run the script from anywhere it is important that you change
      the file permissions accordingly and that your $PATH variable points towards the
      working directory where the files are located. 

There are three things to note about the shell script:

2. As the script stands it assumes that the $javaFx (line 19) variable points to the
   javafx library within your system i.e. it is a path variable saved in your .bashrc file or equivalent.
   you can choose to remove this and instead hardcode the path to the library.

3. you can rename the shell script however you want. Since this is the command that you will be using
   it is only logical that you can call it whatever you want. Do not rename the .java or .class files
   if you are not comfortable with the way java works, if you do only do so at your own risk.

Once you run the the script, if the video file you provided is not in a supported format, you will
be asked if you want the program to attempt to produce a supported file using ffmpeg
