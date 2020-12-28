package com.diego.kitchen.patterns.imp;

import com.diego.kitchen.patterns.interfaces.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Square");
    }
}
