package com.freebird.designpatterns.myabstractfactory;

public class Rectangle implements Shape {

    @Override
    public void draw(){
        System.out.println("We're inside the Rectangle::draw(). This is implementing the Shape interface's draw() method");
    }
}
