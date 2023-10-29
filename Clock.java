package com.mycompany.widgets;

import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class Clock extends Pane {

    private static final int CLOCK_RADIUS = 200;
    private static final int CLOCK_CENTER_X = CLOCK_RADIUS + 10;
    private static final int CLOCK_CENTER_Y = CLOCK_RADIUS + 10;
    private static final int CLOCK_STROKE_WIDTH = 3;

    private static final double TICK_MARK_LENGTH = 20;
    private static final double TICK_MARK_WIDTH = 2;


    //private static final int ANIMATION_DURATION_HOUR = 24;
    //private static final int ANIMATION_DURATION_MINUTE = 60;

    private final Circle clockFace = new Circle(CLOCK_CENTER_X, CLOCK_CENTER_Y, CLOCK_RADIUS, Color.WHITE);
    private final List<Node> tickMarks = new ArrayList<>();
    private final Line hourHand = new Line(0,25,0,-70);
    private final Line minuteHand = new Line(0,50,0,-70);
    private final Line secondHand = new Line(0,70,0,-70);
    private final Text timeText = new Text();

    //private RotateTransition hourHandRotateAnimation;
    //private RotateTransition minuteHandRotateAnimation;
    //private RotateTransition secondHandRotateAnimation;

    public Clock() {
        
        
        clockFace.setStroke(Color.BLACK);
        clockFace.setStrokeWidth(CLOCK_STROKE_WIDTH);
        getChildren().add(clockFace);
       
        for (int i = 0; i < 24; i++) {
            Line tickMark = new Line();
            double angle = i * 15 * Math.PI / 180;
            double startX = CLOCK_CENTER_X + (CLOCK_RADIUS - TICK_MARK_LENGTH) * Math.sin(angle);
            double startY = CLOCK_CENTER_Y - (CLOCK_RADIUS - TICK_MARK_LENGTH) * Math.cos(angle);
            double endX = CLOCK_CENTER_X + CLOCK_RADIUS * Math.sin(angle);
            double endY = CLOCK_CENTER_Y - CLOCK_RADIUS * Math.cos(angle);
            tickMark.setStartX(startX);
            tickMark.setStartY(startY);
            tickMark.setEndX(endX);
            tickMark.setEndY(endY);
            tickMark.setStrokeWidth(TICK_MARK_WIDTH);
            tickMark.setStroke(Color.BLACK);
            tickMarks.add(tickMark);
        }
        getChildren().addAll(tickMarks);    
        
        
       
    timeText.setX(CLOCK_CENTER_X - 40);
    timeText.setY(CLOCK_CENTER_Y + 100);
    timeText.setFont(Font.font(20));
    getChildren().add(timeText);
    

  // getChildren().addAll(hourHand, minuteHand, secondHand);
  
    LocalTime time = LocalTime.now();
    int hours = time.getHour();
    int minutes = time.getMinute();
    int seconds = time.getSecond();
   
    
    
        Timeline timeline = new Timeline(
        new KeyFrame(Duration.seconds(1), event -> updateTime())    );
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
    
    secondHand.setStrokeWidth(2);
    secondHand.setStroke(Color.RED);
    minuteHand.setStrokeWidth(4);
    minuteHand.setStroke(Color.BLACK);
    hourHand.setStrokeWidth(8);
    hourHand.setStroke(Color.BLACK);
    

Circle path = new Circle(CLOCK_CENTER_X, CLOCK_CENTER_Y, CLOCK_RADIUS / 2, Color.TRANSPARENT);
path.setRotate(-90);

getChildren().add(path);
getChildren().add(secondHand); // add secondHand to the pane first
getChildren().add(minuteHand);
getChildren().add(hourHand);


// create PathTransition and start animation
PathTransition p = new PathTransition();
p.setDuration(Duration.seconds(60));
p.setPath(path);
p.setNode(secondHand);
p.setCycleCount(Timeline.INDEFINITE);
p.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT); // set orientation to none
p.jumpTo(Duration.seconds(seconds));
p.play();

PathTransition p2 = new PathTransition();
p2.setDuration(Duration.minutes(60));
p2.setPath(path);
p2.setNode(minuteHand);
p2.setCycleCount(Timeline.INDEFINITE);
p2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT); // set orientation to none
p2.jumpTo(Duration.minutes(minutes));
p2.play();

PathTransition p3 = new PathTransition();
p3.setDuration(Duration.hours(24));
p3.setPath(path);
p3.setNode(hourHand);
p3.setCycleCount(Timeline.INDEFINITE);
p3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT); // set orientation to none
p3.jumpTo(Duration.hours(hours));
p3.play();


    
        

    }


private void updateTime() {
    
        LocalTime time = LocalTime.now();
    int hours = time.getHour();
    int minutes = time.getMinute();
    int seconds = time.getSecond();
    
    timeText.setText(time.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    
}

/* Circle path = new Cricle();
path.radiusProperty().bind(viwer.widthProperty().multiply(0.3f);
path.setRotation(-90);
Line Hand = new Line(1,1,1,11,);
hand.setStrokeWidth(4);
hand.setStroke(Color.RED);
viewer.getChildren().add(Hand);
p = new PathTransition(Duration.seconds(60),path,Hand);
p.setCycleCount(Timeline.INDEFINITE);
p.setOrientation(PathTransition.OrientationType.Orthogonal_TO_TANGENT);

p.jumpTo(Duration.seconds(CURRENTTIME);
*/



}

