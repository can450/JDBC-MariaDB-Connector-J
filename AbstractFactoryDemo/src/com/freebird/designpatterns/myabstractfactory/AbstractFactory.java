package com.freebird.designpatterns.myabstractfactory;

public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shapeType);
}
