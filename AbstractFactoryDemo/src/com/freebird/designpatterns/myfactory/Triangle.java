package com.freebird.designpatterns.myfactory;


public class Triangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Now we're inside the Triangle class");
    }
}
