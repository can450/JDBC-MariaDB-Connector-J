package com.freebird.designpatterns.myabstractfactory;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("We're inside the Square::draw(). This is implementing the Shape interface's draw() method");
    }
}
