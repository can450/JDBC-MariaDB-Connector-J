package com.freebird.designpatterns.myabstractfactory;

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("We're inside Green::fill(), this is an implementation of Color Interface");
    }
}
