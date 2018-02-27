package com.freebird.designpatterns.myfactory;

public class myFactory {

    /**
     * @return Shape object, which might be Triangle, Square, Circle
     */
    public Shape getShape(String ShapeString){
        if(ShapeString.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }
        else if(ShapeString.equalsIgnoreCase("Triangle")){
            return new Triangle();
        }
        else if(ShapeString.equalsIgnoreCase("Square")){
            return new Square();
        }
        return null;
    }
}
