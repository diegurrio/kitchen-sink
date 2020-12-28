package com.diego.kitchen.patterns.visitor;

import com.diego.kitchen.patterns.interfaces.ComputerPart;
import com.diego.kitchen.patterns.interfaces.ComputerPartVisitor;

public class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}