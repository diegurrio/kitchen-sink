package com.diego.kitchen.structures;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    /**
     * Internal node structure
     * @param <T> Any object that extends Comparable. Use to determine the
     *           location of a node in the tree.
     */
    private class Node<T extends Comparable<T>> {
        public T data;
        public Node<T> left;
        public Node<T> right;

        public Node(final T data) {
            this.data = data;
            left = null;
            right = null;
        }

        public Node() {
            this(null);
        }
    }

    private Node<T> rootNode;
    public BinarySearchTree() {
        rootNode = null;
    }

    /**
     * Add a value to the tree
     * @param value The value to be added.
     */
    public void add(final T value) {
        if (rootNode == null) {
            rootNode = new Node<>(value);
        } else {
            addHelper(rootNode, value);
        }

    }

    /**
     * Helper function to add things to the tree.
     * @param currentNode The current place in the traversal.
     * @param value The value to be added.
     * @TODO: Balance the tree when a new node is added.
     */
    private void addHelper(Node<T> currentNode, final T value) {
        if (currentNode == null) {
            return;
        }

        // Check where in the tree the item needs to go.
        final T currentValue = currentNode.data;
        if (currentValue.compareTo(value) < 0) {
            // Is greater go to the right of the tree
            if (currentNode.right == null) {
                currentNode.right = new Node<>(value);
            } else {
                addHelper(currentNode.right, value);
            }
        } else {
            if (currentNode.left == null) {
                currentNode.left = new Node<>(value);
            } else {
                addHelper(currentNode.left, value);
            }
        }
    }

    public String printPreOrder() {
        final StringBuilder stringBuilder = new StringBuilder("[ ");
        printPreOrder(stringBuilder, rootNode);
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    private void printPreOrder(final StringBuilder stringBuilder, Node<T> currentNode) {
        if (currentNode == null) {
            return;
        }

        stringBuilder.append(currentNode.data.toString());
        stringBuilder.append(", ");

        printPreOrder(stringBuilder, currentNode.left);
        printPreOrder(stringBuilder, currentNode.right);
    }

    public String printInOrder() {
        final StringBuilder stringBuilder = new StringBuilder("[ ");
        printInOrder(stringBuilder, rootNode);
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    private void printInOrder(final StringBuilder stringBuilder, final Node<T> currentNode) {
        if (currentNode == null) {
            return;
        }

        printPreOrder(stringBuilder, currentNode.left);

        stringBuilder.append(currentNode.data.toString());
        stringBuilder.append(", ");

        printPreOrder(stringBuilder, currentNode.right);
    }

    public String printPostOrder() {
        final StringBuilder stringBuilder = new StringBuilder("[ ");
        printPostOrder(stringBuilder, rootNode);
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    private void printPostOrder(final StringBuilder stringBuilder, final Node<T> currentNode) {
        if (currentNode == null) {
            return;
        }

        printPreOrder(stringBuilder, currentNode.left);
        printPreOrder(stringBuilder, currentNode.right);

        stringBuilder.append(currentNode.data.toString());
        stringBuilder.append(", ");
    }

    public String printBreathFirstOrder() {
        final StringBuilder builder = new StringBuilder("[ ");
        printBreathFirstOrder(builder, rootNode);
        builder.delete(builder.length() - 2, builder.length());
        builder.append(" ]");

        return builder.toString();
    }

    private void printBreathFirstOrder(final StringBuilder builder, final Node<T> rootNode) {
        final Queue<Node<T>> queue = new ArrayDeque<Node<T>>();
        queue.add(rootNode);

        while(!queue.isEmpty()) {
            final Node<T> currentNode = queue.poll();
            builder.append(currentNode.data + ", ");

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
}
