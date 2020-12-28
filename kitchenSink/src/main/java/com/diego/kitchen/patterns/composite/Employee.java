package com.diego.kitchen.patterns.composite;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    public Employee(final String name, final String dept, final int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;

        subordinates = new ArrayList<>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    /**
     * Prints an employee and all subordinates.
     * @return  a string representation of the object.
     */
    @NonNull
    @Override public String toString(){
        return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary+" ]");
    }
}
