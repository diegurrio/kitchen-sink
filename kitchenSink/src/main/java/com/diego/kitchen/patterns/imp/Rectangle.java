package com.diego.kitchen.patterns.imp;

import com.diego.kitchen.patterns.interfaces.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
