package com.mycompany.widgets;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application implements EventHandler
{
    private FlowPane window;
    private Pane viewer;
    private Eyes panel1;
    private Clock panel2;
    @Override
    public void start(Stage stage) {
       panel1 = new Eyes();
       panel2 = new Clock();
       viewer = new Pane();
       window = new FlowPane();
       window.setPrefSize(500,500);
       viewer.setPrefSize(500,500);
       Button p1 = new Button();
       p1.setText("Eyes");
       p1.setOnAction(this);
       Button p2 = new Button();
       p2.setText("Clock");
       p2.setOnAction(this);
       window.getChildren().addAll(viewer, p1,p2);
       Scene myScene = new Scene(window);
       stage.setScene(myScene);
       stage.show();
    }

    public static void main(String[] args) {
        launch();
    }    


    @Override
    public void handle(Event t) {
        
             if(t.getSource().toString().contains("Eyes"))
      {
          viewer.getChildren().clear();
          viewer.getChildren().add(panel1);
      }
      if(t.getSource().toString().contains("Clock"))
      {
         viewer.getChildren().clear();
         viewer.getChildren().add(panel2);
      }
    }
}

