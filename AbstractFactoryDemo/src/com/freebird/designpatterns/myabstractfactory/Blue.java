package com.freebird.designpatterns.myabstractfactory;

public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("We're inside Blue::fill(), this is an implementation of Color Interface");
    }
}

