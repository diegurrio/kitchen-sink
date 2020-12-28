package com.diego.kitchen.patterns.decorator;

import com.diego.kitchen.patterns.imp.Circle;
import com.diego.kitchen.patterns.imp.Rectangle;
import com.diego.kitchen.patterns.interfaces.Shape;

import junit.framework.TestCase;

import org.junit.Test;

public class DecoratorTest extends TestCase {

    @Test
    public void testDecoratorPattern() {
        final Shape circle = new Circle();
        final Shape redCircle = new RedShapeDecorator(new Circle());
        final Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}