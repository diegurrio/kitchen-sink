package com.diego.kitchen.structures;

import junit.framework.TestCase;

import org.junit.Test;

public class BinarySearchTreeTest extends TestCase {

    @Test
    public void testAdd() {
        final BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(3);
        bst.add(6);
        bst.add(1);
        bst.add(66);
        bst.add(429);

        assertNotNull(bst);
    }

    @Test
    public void testPrintInOrder() {
        final BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(3);
        bst.add(6);
        bst.add(1);
        bst.add(66);
        bst.add(429);

        final String result = bst.printInOrder();
        assertEquals("[ 3, 1, 6, 66, 429 ]", result);
    }

    @Test
    public void testPrintPreOrder() {
        final BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(3);
        bst.add(6);
        bst.add(1);
        bst.add(66);
        bst.add(429);

        final String result = bst.printPreOrder();
        assertEquals("[ 1, 3, 6, 66, 429 ]", result);
    }

    @Test
    public void testPrintPostOrder() {
        final BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(3);
        bst.add(6);
        bst.add(1);
        bst.add(66);
        bst.add(429);

        final String result = bst.printPostOrder();
        assertEquals("[ 1, 6, 66, 429, 3 ]", result);
    }
}