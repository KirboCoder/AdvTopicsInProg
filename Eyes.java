/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.widgets;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 *
 * @author Mike
 */
public class Eyes extends Pane implements EventHandler<Event> {

    private Circle c1;
    private Circle c2;
    private Circle c3;
    private Circle c4;
    private Rectangle r;
    private Pane interact;

    public Eyes() {
        interact = new Pane();
        interact.setPrefSize(500, 500);
        interact.setMaxHeight(500);
        interact.setMaxWidth(500);

        setPrefHeight(500);
        setPrefHeight(500);

        interact.setLayoutX(10);
        interact.setLayoutY(10);

        r = new Rectangle();
        r.setLayoutX(5);
        r.setLayoutY(5);
        r.setWidth(480);
        r.setHeight(480);
        r.setStrokeWidth((10));
        r.setFill((Color.TRANSPARENT));
        r.setStroke(Color.BLACK);

        c2 = new Circle();
        c2.setRadius(30);
        c2.setCenterX(125);
        c2.setCenterY(125);
        c2.setFill(Color.TRANSPARENT);
        c2.setStroke(Color.BLACK);
        
        c1 = new Circle();
        c1.setRadius(15);
        c1.setCenterX(125);
        c1.setCenterY(125);
        c1.setFill(Color.BLACK);
        c1.setStroke(Color.BLACK);
        
        c4 = new Circle();
        c4.setRadius(30);
        c4.setCenterX(325);
        c4.setCenterY(125);
        c4.setFill(Color.TRANSPARENT);
        c4.setStroke(Color.BLACK);
        
        c3 = new Circle();
        c3.setRadius(15);
        c3.setCenterX(325);
        c3.setCenterY(125);
        c3.setFill(Color.BLACK);
        c3.setStroke(Color.BLACK);

        interact.getChildren().addAll(c2, c1);
        interact.getChildren().addAll(c4, c3);
        getChildren().addAll(r, interact);

        interact.setOnMousePressed(this);
        interact.setOnMouseMoved(this);
        interact.setOnMouseReleased(this);
    }

@Override
public void handle(Event t) {
    if (t.getEventType() == MouseEvent.MOUSE_MOVED) {
        MouseEvent mouseEvent = (MouseEvent) t;
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        double deltaX = x - c2.getCenterX();
        double deltaY = y - c2.getCenterY();
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        if (distance < c2.getRadius() - c1.getRadius()) {
            c1.setCenterX(x);
            c1.setCenterY(y);
        } else {
            double angle = Math.atan2(deltaY, deltaX);
            double newX2 = c2.getCenterX() + (c2.getRadius() - c1.getRadius()) * Math.cos(angle);
            double newY2 = c2.getCenterY() + (c2.getRadius() - c1.getRadius()) * Math.sin(angle);
            c1.setCenterX(newX2);
            c1.setCenterY(newY2);
        }
        double deltaX2 = x - c4.getCenterX();
        double deltaY2 = y - c4.getCenterY();
        double distance2 = Math.sqrt(deltaX2 * deltaX2 + deltaY2 * deltaY2);
        if (distance2 < c4.getRadius() - c3.getRadius()) {
            c3.setCenterX(x);
            c3.setCenterY(y);
        } else {
            double angle = Math.atan2(deltaY2, deltaX2);
            double newX2 = c4.getCenterX() + (c4.getRadius() - c3.getRadius()) * Math.cos(angle);
            double newY2 = c4.getCenterY() + (c4.getRadius() - c3.getRadius()) * Math.sin(angle);
            c3.setCenterX(newX2);
            c3.setCenterY(newY2);
        }
        
    } 
    if (t.getEventType() == MouseEvent.MOUSE_PRESSED) {
        interact.getChildren().remove(c1);
        c2.setFill(Color.BLACK);
        c2.toFront();
        c1.toBack();
    }

    if (t.getEventType() == MouseEvent.MOUSE_RELEASED) {
        interact.getChildren().addAll(c1);
        c2.setFill(Color.TRANSPARENT);
    }
        if (t.getEventType() == MouseEvent.MOUSE_PRESSED) {
        interact.getChildren().remove(c3);
        c4.setFill(Color.BLACK);
        c4.toFront();
        c3.toBack();
    }

    if (t.getEventType() == MouseEvent.MOUSE_RELEASED) {
        interact.getChildren().addAll(c3);
        c4.setFill(Color.TRANSPARENT);
    }
    
    }

}


