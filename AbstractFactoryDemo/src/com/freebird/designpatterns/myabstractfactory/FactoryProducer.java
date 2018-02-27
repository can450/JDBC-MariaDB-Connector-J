package com.freebird.designpatterns.myabstractfactory;

public class FactoryProducer {

    //STATIC METHOD! YOU DON'T NEED TO CREATE AN INSTANCE OF THIS CLASS
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE"))
            return new ShapeFactory();
        else if(choice.equalsIgnoreCase("COLOR"))
            return new ColorFactory();
        else
            return null;
    }
}
