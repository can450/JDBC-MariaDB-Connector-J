package com.freebird.designpatterns.myabstractfactory;

public class mySingleton {

    private static mySingleton ourInstance = new mySingleton();

    public static mySingleton getInstance() {
        return ourInstance;
    }

    private mySingleton() {
    }
}
