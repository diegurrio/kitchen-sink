package com.diego.kitchen.structures;

import junit.framework.TestCase;

import org.junit.Test;

public class SingleLinkedListTest extends TestCase {

    @Test
    public void testAdd() {
        final SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        linkedList.add(420);
        linkedList.add(69);
        linkedList.add(666);
    }

    @Test
    public void testGet() {
        final SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        linkedList.add(420);
        linkedList.add(69);
        linkedList.add(666);

        final Integer value = linkedList.get(1);
        assertEquals(69, value.intValue());
    }

    @Test
    public void testPrintList() {
        final SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        linkedList.add(420);
        linkedList.add(69);
        linkedList.add(666);

        final String list = linkedList.toString();
        assertEquals("[ 420, 69, 666 ]", list.toString());
    }

    @Test
    public void testBuildStringInReversedOrder() {
        final SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        linkedList.add(420);
        linkedList.add(69);
        linkedList.add(666);

        final String list = linkedList.buildStringInReversedOrder();
        assertEquals("[ 666, 69, 420 ]", list.toString());
    }
}