package com.diego.kitchen.patterns.factory;

import com.diego.kitchen.patterns.imp.Circle;
import com.diego.kitchen.patterns.imp.Rectangle;
import com.diego.kitchen.patterns.imp.Square;
import com.diego.kitchen.patterns.interfaces.Shape;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

public class ShapeFactory {

    // Define the list of accepted constants and declare the ShapeType annotation
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({SHAPE_CIRCLE, SHAPE_RECTANGLE, SHAPE_SQUARE})
    public @interface ShapeType {}

    // Declare the constants
    public static final int SHAPE_CIRCLE = 0;
    public static final int SHAPE_RECTANGLE = 1;
    public static final int SHAPE_SQUARE = 2;
    
    // Use getShape method to get object of type shape.
    public Shape getShape(@ShapeType int shapeType){
        switch (shapeType) {
            case SHAPE_CIRCLE:
                return new Circle();
            case SHAPE_RECTANGLE:
                return new Rectangle();
            case SHAPE_SQUARE:
                return new Square();
            default:
                return null;
        }
    }
}
