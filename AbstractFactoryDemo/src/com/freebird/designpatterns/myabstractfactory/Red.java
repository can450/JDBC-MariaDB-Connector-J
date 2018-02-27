package com.freebird.designpatterns.myabstractfactory;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("We're inside Red::fill(), this is an implementation of Color Interface");
    }
}
