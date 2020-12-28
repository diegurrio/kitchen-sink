package com.diego.kitchen.patterns.singleton;

public class SingleObject {

    // Create an object of SingleObject
    private static SingleObject instance = new SingleObject();

    // We make the constructor private to prevent instantiation.
    private SingleObject() { }

    // Get the only object available of this type.
    public static SingleObject getInstance() {
        return instance;
    }

    /**
     * Utility function.
     */
    public void showMessage(){
        System.out.println("Hello World!");
    }
}
