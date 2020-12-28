package com.diego.kitchen.patterns.interfaces;

public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
