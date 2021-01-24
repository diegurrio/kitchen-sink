package com.diego.kitchen.structures;

// TODO: Implement the List interface.

import androidx.annotation.NonNull;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SingleLinkedList<T extends Comparable<T>> implements Iterable<T>{

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new SingleLinkedListIterator(this);
    }

    class SingleLinkedListIterator implements Iterator<T> {

        private Node current;

        public SingleLinkedListIterator(@NonNull final SingleLinkedList<T> list) {
            current = list.rootNode;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // Internal list node structure
    private class Node {
        public Node next;
        public T data;

        public Node(final T data) {
            this.data = data;
            this.next = null;
        }

        public Node() {
            this(null);
        }

    }

    private Node rootNode;
    private Integer numberOfItems;

    public SingleLinkedList() {
        rootNode = null;
        numberOfItems = 0;
    }

    /**
     * Adds an item to the end of the linked list.
     * @param data
     */
    public void add(final T data) {
        if (rootNode == null) {
            // Add the first item of the list.
            rootNode = new Node(data);
            numberOfItems++;
        } else {
            // We already have root. Navigate to the end of the list and add the item.
            Node currentNode = rootNode;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = new Node(data);
            numberOfItems++;
        }
    }

    /**
     * Gets an item located at the specified index in the list.
     * @param index The index in the list to be inspected
     * @return The item at located at index
     */
    public T get(final int index) throws IndexOutOfBoundsException {
        if (index > numberOfItems) {
            throw new IndexOutOfBoundsException("List size: " + index);
        }

        int currentIndex = 0;
        Node currentNode = rootNode;
        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        return currentNode.data;
    }

    /**
     * Prints the contents of the list in sequential order starting with the first element.
     */
    public String toString() {
        final StringBuilder result = new StringBuilder("[ ");
        buildStringInOrder(rootNode, result);

        return result.toString();
    }

    private void buildStringInOrder(final Node node, final StringBuilder stringBuilder) {
        if (node == null) {
            // Nothing to print
            stringBuilder.append(" ]");
            return;
        }

        stringBuilder.append(node.data.toString());
        if (node.next != null) {
            stringBuilder.append(", ");
        }

        buildStringInOrder(node.next, stringBuilder);
    }

    public String buildStringInReversedOrder() {
        final StringBuilder result = new StringBuilder("[ ");
        buildStringInReversedOrder(rootNode, result);
        result.append(" ]");

        return result.toString();
    }


    private void buildStringInReversedOrder(final Node node, final StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }

        buildStringInReversedOrder(node.next, stringBuilder);
        stringBuilder.append(node.data.toString());
        if (node != rootNode) {
            stringBuilder.append(", ");
        }
    }
}
