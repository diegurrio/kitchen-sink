package com.diego.kitchen.patterns.imp;

import com.diego.kitchen.patterns.interfaces.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
