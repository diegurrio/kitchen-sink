package com.diego.kitchen.patterns.factory;

import com.diego.kitchen.patterns.interfaces.Shape;

import junit.framework.TestCase;

import org.junit.Test;

public class ShapeFactoryTest extends TestCase {

    @Test
    public void testGetShape() {
        ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape(ShapeFactory.SHAPE_CIRCLE);

        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape(ShapeFactory.SHAPE_RECTANGLE);

        //call draw method of Rectangle
        shape2.draw();

        //get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape(ShapeFactory.SHAPE_SQUARE);

        //call draw method of square
        shape3.draw();
    }
}