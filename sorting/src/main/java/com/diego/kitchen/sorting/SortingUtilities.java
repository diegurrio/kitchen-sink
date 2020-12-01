package com.diego.kitchen.sorting;

import java.util.List;

public class SortingUtilities {

    // Make the constructor private to prevent instantiation of this utility class.
    private SortingUtilities(){}

    /**
     * Sort a java.util.list using bubble sort.
     * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble Sort</a>
     * @param array The list to be sorted
     * @param <T> Any object that extends the comparable interface
     */
    public static <T extends Comparable<T>> void bubbleSort(List<T> array) {
        // For each item in the list. Check of it's larger than it's forward adjacent item
        // and start bubbling the item up until we find an item that is lager.
        final int numberOfEntries = array.size();

        for (int index = 0; index < numberOfEntries; index ++) {
            for (int bubbleIndex = 0; bubbleIndex < numberOfEntries - 1; bubbleIndex++) {
                if (array.get(bubbleIndex).compareTo(array.get(bubbleIndex + 1)) > 0) {
                    // Swap the numbers because they are our of place.
                    T temp = array.get(bubbleIndex);
                    array.set(bubbleIndex, array.get(bubbleIndex + 1));
                    array.set(bubbleIndex + 1, temp);
                }
            }
        }
    }

    /**
     * Sort a java.util.list using bubble sort.
     * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble Sort</a>
     * @param array The list to be sorted
     * @param <T> Any object that extends the comparable interface
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        // For each item in the list. Check of it's larger than it's forward adjacent item
        // and start bubbling the item up until we find an item that is lager.
        final int numberOfEntries = array.length;
        for (int index = 0; index < numberOfEntries; index ++) {
            for (int bubbleIndex = 0; bubbleIndex < numberOfEntries - 1; bubbleIndex ++) {
                if (array[bubbleIndex].compareTo(array[bubbleIndex + 1]) > 0) {
                    // Swap the numbers because they are our of place.
                    T temp = array[bubbleIndex];
                    array[bubbleIndex] = array[bubbleIndex + 1];
                    array[bubbleIndex + 1] = temp;
                }
            }
        }

    }
}
