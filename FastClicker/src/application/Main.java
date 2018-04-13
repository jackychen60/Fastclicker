package application;
 
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Main extends Application {
	private int score = 0;
	private boolean scoring = false;
	private long timeStep;
	
    public static void main(String[] args) {
        launch(args);
    }
   
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fastclicker");
        Button btn = new Button();
        btn.setText("Click.");
        Text txt = new Text(10,0,"Click.");
        btn.setOnAction(new EventHandler<ActionEvent>() {
          
            @Override
            public void handle(ActionEvent event) 
            {
            	
               if(scoring) 
               {
            	   score++;
            	   }
               else 
               {
            	  score--;
               }
            }
        });
         timeStep = System.nanoTime() +1000000000L;
        new AnimationTimer()
        {
        	 public void handle(long now)
        	{
        		if(now > timeStep)
        		{
        			timeStep = now + 10000000000L;
        			scoring = !scoring;
        		}
        		if(!scoring)
        		{
        			btn.setText("Don't click!");   			
        		}

        		else
        		{
        			btn.setText("Click me");
        			
        		}
                 
        		txt.setText("SCORE: " + Integer.toString(score));
        		
            }
        }.start();
   
        
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(txt);
        root.setAlignment(txt, Pos.TOP_LEFT);
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }
}