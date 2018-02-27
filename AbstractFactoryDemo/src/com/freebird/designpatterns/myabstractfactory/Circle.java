package com.freebird.designpatterns.myabstractfactory;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("We're inside the Circle::draw(). This is implementing the Shape interface's draw() method");
    }
}
