package com.diego.kitchen.patterns.visitor;

import com.diego.kitchen.patterns.interfaces.ComputerPart;

import junit.framework.TestCase;

import org.junit.Test;

public class ComputerTest extends TestCase {

    @Test
    public void testVisitorPattern() {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}