package com.diego.kitchen.structures;

import androidx.annotation.NonNull;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new BinarySearchTreeIterator(this);
    }

    private class BinarySearchTreeIterator implements Iterator<T> {

        // We use a stack to flatten the tree into a list that we can traverse in order. Another
        // approach is to use a form of controlled recursion.
        // TODO: Implement an iterator that uses recursion.

        private Stack<Node<T>> auxiliaryStack;

        public BinarySearchTreeIterator(@NonNull final BinarySearchTree<T> tree) {
            auxiliaryStack = new Stack<>();
            Node<T> rootNode = tree.rootNode;
            while (rootNode != null) {
                auxiliaryStack.push(rootNode);
                rootNode = rootNode.left;
            }
        }
        @Override
        public boolean hasNext() {
            return !auxiliaryStack.isEmpty();
        }

        @Override
        public T next() {
            Node<T> node = auxiliaryStack.pop();
            final T result = node.data; // Prepare the data to be returned.
            // Move to the next node.
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    auxiliaryStack.push(node);
                    node = node.left;
                }
            }

            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
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
     * Remove an item from the tree if it exists.
     * @param value The value to be removed.
     */
    public void remove(final T value) {
        if (rootNode == null) {
            return;
        }

        Node<T> currentNode = rootNode;
        Node<T> previewsNode = null;
        while (currentNode != null) {
            if (currentNode.data.equals(value)) {
                // We found the value to be deleted.
                System.out.println("Yes shit!");
                break;
            } else if (value.compareTo(currentNode.data) > 0){
                previewsNode = currentNode;
                currentNode = currentNode.right;
            } else {
                previewsNode = currentNode;
                currentNode = currentNode.left;
            }
        }

        // We did not find it.
        if (currentNode == null) {
            return;
        }

        // One node tree.
        if (previewsNode == null) {
            rootNode = null;
        }

        // First case. The value is a leaf.
        if (currentNode.left == null && currentNode.right == null) {
            if (currentNode == previewsNode.left) {
                previewsNode.left = null;
            } else {
                previewsNode.right = null;
            }
        }

        // Second case. The value has one child.
        Node<T> child = null;
        if (currentNode.left == null && currentNode.right != null) {
            // The right child.
            child = currentNode.right;
        }

        if (currentNode.left != null && currentNode.right == null) {
            child = currentNode.right;
        }
        // The current node does indeed have only one child.
        if (child != null) {
            if (previewsNode == null) {
                // Special case. The root only has one child.
                rootNode = child;
            }

            if (previewsNode.left == currentNode) {
                previewsNode.left = child;
            } else {
                previewsNode.right = child;
            }
        }

        // Third case. The value has two children.
        if (currentNode.left != null && currentNode.right != null) {
            
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
