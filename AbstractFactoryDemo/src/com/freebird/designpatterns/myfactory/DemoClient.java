package com.freebird.designpatterns.myfactory;

public class DemoClient {
    //

    public static void main() {
        //I want to get a shape, and I want to specify what Shape in here
        //but getShape is not a static method, so we cannot call it without creating a factory
        //Shape myNewRectangle=myFactory.getShape("Triangle");
        myFactory myNewFactory = new myFactory();
        Shape myNewTriangle = myNewFactory.getShape("Triangle");
        Shape myNewCircle = myNewFactory.getShape("Circle");
        Shape myNewSquare = myNewFactory.getShape("square");


        myNewTriangle.draw();
    }

}
