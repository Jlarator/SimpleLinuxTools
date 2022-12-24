import javafx.application.Application; 
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.stage.StageStyle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;
import java.awt.Toolkit;
import javafx.util.Duration;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;


public class screenSaver extends Application {

    private String fileName;
    private MediaPlayer player;
    private Scene scene; 
    
    @Override
    public void start(Stage primaryStage) {

	primaryStage.initStyle(StageStyle.UNDECORATED); 

	if( this.getParameters().getRaw().size() == 0) {
	    System.out.println("Not enough arguments, pass filepath to video"); 
	    System.exit(1); 
	} else {
	    this.fileName = this.getParameters().getRaw().get(0); 
	}

	File file = new File(this.fileName);
	System.out.println(file.toURI().toString());
	
	Media media = new Media(file.toURI().toString());
	player = new MediaPlayer(media);
	player.setOnEndOfMedia(() -> {
		System.out.println("looping..");
		
		player.seek(Duration.ZERO); 
	    } );
	
	MediaView view = new MediaView(player);

	double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	view.setFitWidth(width); 
	view.setFitHeight(height);
	
	Group root = new Group();	
	root.getChildren().add(view); 
	
	scene = new Scene(root, width, height);

	scene.setOnKeyPressed( (e) -> processEvent(e));

        primaryStage.setScene(scene);
	primaryStage.setMaximized(true);
        primaryStage.show();
	
	player.play(); 
	
    }
    
    public static void main(String[] args) {
        Application.launch(screenSaver.class, args);
    }

    public void exitSuccess() {
	    player.dispose(); 
	    Platform.exit(); 
    }
    
    public void processEvent(KeyEvent event){
	
        if (event.isAltDown() || event.isMetaDown()){
	    exitSuccess(); 
	}
    }
}
