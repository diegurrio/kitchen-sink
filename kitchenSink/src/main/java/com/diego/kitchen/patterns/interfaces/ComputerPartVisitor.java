package com.diego.kitchen.patterns.interfaces;

import com.diego.kitchen.patterns.visitor.Computer;
import com.diego.kitchen.patterns.visitor.Keyboard;
import com.diego.kitchen.patterns.visitor.Monitor;
import com.diego.kitchen.patterns.visitor.Mouse;

public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
}
