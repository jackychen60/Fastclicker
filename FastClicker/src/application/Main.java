package application;
 
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private boolean scoring;
	private int score;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fastclicker");
        Button btn = new Button();
        btn.setText("Click.");
        Text txt = new Text(10,0,"Click score");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
          

			@Override
            public void handle(ActionEvent event) {
                if(scoring)
                {
                	score++;
                }
            }
        });
        
        new AnimationTimer()
        {
        	long timeStep = System.nanoTime() +1000000000L;
        	public void handle(long now)
        	{
        		if(now<timeStep) {
        			btn.setText("Click");
        			
        		}
        		if(now>timeStep)
        	
        		{
        			txt.setText("Score:"+Integer.toString(score));
        		}
        		
        	}
        }.start();
   
        
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}