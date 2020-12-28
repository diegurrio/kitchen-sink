package com.diego.kitchen.patterns.singleton;

import junit.framework.TestCase;

import org.junit.Test;

public class SingleObjectTest extends TestCase {

    @Test
    public void testGetInstance() {

        final SingleObject firstObject = SingleObject.getInstance();
        final SingleObject secondObject = SingleObject.getInstance();

        firstObject.showMessage();
        secondObject.showMessage();

        assertEquals(firstObject, secondObject);
    }
}