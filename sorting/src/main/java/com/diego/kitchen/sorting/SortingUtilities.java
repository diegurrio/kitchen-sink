package com.diego.kitchen.sorting;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;

public class SortingUtilities {

    // Make the constructor private to prevent instantiation of this utility class.
    private SortingUtilities() {
    }

    /**
     * Sort a java.util.list using bubble sort.
     *
     * @param array The list to be sorted
     * @param <T>   Any object that extends the comparable interface
     * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble Sort</a>
     */
    public static <T extends Comparable<T>> void bubbleSort(List<T> array) {
        // For each item in the list. Check of it's larger than it's forward adjacent item
        // and start bubbling the item up until we find an item that is lager.
        final int numberOfEntries = array.size();

        for (int index = 0; index < numberOfEntries; index++) {
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
     *
     * @param array The list to be sorted
     * @param <T>   Any object that extends the comparable interface
     * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble Sort</a>
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        // For each item in the list. Check of it's larger than it's forward adjacent item
        // and start bubbling the item up until we find an item that is lager.
        final int numberOfEntries = array.length;
        for (int index = 0; index < numberOfEntries; index++) {
            for (int bubbleIndex = 0; bubbleIndex < numberOfEntries - 1; bubbleIndex++) {
                if (array[bubbleIndex].compareTo(array[bubbleIndex + 1]) > 0) {
                    // Swap the numbers because they are our of place.
                    T temp = array[bubbleIndex];
                    array[bubbleIndex] = array[bubbleIndex + 1];
                    array[bubbleIndex + 1] = temp;
                }
            }
        }
    }

    /**
     * Sort a java.util.list using merge sort.
     *
     * @param list The list to be sorted
     * @param <T>  Any object that extends the comparable interface
     */
    public static <T extends Comparable<T>> List<T> mergeSort(final List<T> list) {
        final int listSize = list.size();
        // We must have an array of at least one item.
        if (listSize == 0) {
            throw new InvalidParameterException();
        }

        // Base case/ A list with one item is sorted.
        if (listSize == 1) {
            return list;
        }

        final int middlePoint = listSize / 2;
        final List<T> leftList = list.subList(0, middlePoint);
        final List<T> rightList = list.subList(middlePoint, listSize);

        return merge(mergeSort(leftList), mergeSort(rightList));

    }

    /**
     * Helper method to merge two List in order.
     *
     * @param left  The first array to be merged.
     * @param right The second array to be merged.
     * @return An array with all of the items in both input arrays sorted.
     */
    private static <T extends Comparable<T>> List<T> merge(final List<T> left, final List<T> right) {
        final List<T> result = new ArrayList<T>(); // We don't know what kind of list the input has but we're going to return an array list.

        int leftIndex = 0;
        int rightIndex = 0;
        while ((leftIndex < left.size()) && (rightIndex < right.size())) {
            final T leftItem = left.get(leftIndex);
            final T rightItem = right.get(rightIndex);

            // Check which value is larger and increase the index.
            if (leftItem.compareTo(rightItem) < 0) {
                result.add(leftItem);
                leftIndex++;
            } else {
                result.add(rightItem);
                rightIndex++;
            }
        }

        // Check if there are any leftovers item in any of the two list.
        while (leftIndex < left.size()) {
            result.add(left.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex < right.size()) {
            result.add(right.get(rightIndex));
            rightIndex++;
        }

        return result;
    }

    /**
     * Sort an array using merge sort.
     *
     * @param array The array to be sorted
     * @param <T>   Any object that extends the comparable interface
     * @return
     */
    public static <T extends Comparable<? super T>> T[] mergeSort(final T[] array) {
        final int arrayLength = array.length;
        if (arrayLength == 0) {
            throw new InvalidParameterException();
        }

        if (arrayLength == 1) {
            return array;
        }

        final int midPoint = arrayLength / 2;
        T[] leftArray = Arrays.copyOfRange(array, 0, midPoint);
        T[] rightArray = Arrays.copyOfRange(array, midPoint, arrayLength);

        return merge(mergeSort(leftArray), mergeSort(rightArray));
    }

    /**
     * Helper method to merge two arrays in sorted order together.
     *
     * @param left  One of the arrays to be merged
     * @param right One array to be merged
     * @return A new array with left and right merged in order.
     */
    private static <T extends Comparable<? super T>> T[] merge(T[] left, T[] right) {
        final int resultSize = left.length + right.length;
        final T[] result = (T[]) new Comparable[resultSize];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        while ((leftIndex < left.length) && (rightIndex < right.length)) {
            // The left item is larger than the right item.
            final T leftItem = left[leftIndex];
            final T rightItem = right[rightIndex];
            if (leftItem.compareTo(rightItem) < 0) {
                result[resultIndex] = leftItem;
                leftIndex++;
            } else {
                result[resultIndex] = rightItem;
                rightIndex++;
            }

            resultIndex++;
        }

        // Finish adding any leftover items.
        while (leftIndex < left.length) {
            result[resultIndex] = left[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        while (rightIndex < right.length) {
            result[resultIndex] = right[rightIndex];
            rightIndex++;
            resultIndex++;
        }


        return result;
    }

    /**
     * Sort an array using quick sort.
     *
     * @param <T>  Any object that extends the comparable interface
     * @param list The array to be sorted
     * @return
     */
    public static <T extends Comparable<? super T>> void quickSort(@NonNull final List<T> list) {
        // List cannot be empty.
        if (list.size() == 0) {
            throw new InvalidParameterException();
        }

        // A list with one element is already sorted.
        if (list.size() == 1) {
            return;
        }

        quickSort(list, 0, list.size() - 1);
    }

    /**
     * Recursive helper for quick sort.
     *
     * @param list List to be sorted
     * @param lowerIndex Lower index in the array partition and sorted
     * @param higherIndex Higher index of the array  partition
     * @param <T> An object that implements the comparable interface.
     */
    private static <T extends Comparable<? super T>> void quickSort(List<T> list, final int lowerIndex, final int higherIndex) {
        if (lowerIndex >= higherIndex) {
            return;
        }

        int partionedIndex = partition(list, lowerIndex, higherIndex);
        quickSort(list, lowerIndex, partionedIndex - 1);
        quickSort(list, partionedIndex + 1, higherIndex);
    }

    private static <T extends Comparable<? super T>> int partition(List<T> list, final int lowerIndex, final int higherIndex) {

        /**
         * We move all elements that are less than pivot value to the left side of the partitioned
         * index.
         */
        final T pivotValue = list.get(higherIndex);
        int partitionedIndex = lowerIndex;

        for (int index = lowerIndex; index < higherIndex; index++) {
            // If this element is greater than our pivot value.
            if (list.get(index).compareTo(pivotValue) < 0) {
                // Swap the elements.
                swapElements(list, index, partitionedIndex);
                partitionedIndex++;
            }
        }

        swapElements(list, partitionedIndex, higherIndex);
        return partitionedIndex;
    }

    /**
     * Swaps the elements at indexA and indexB
     *
     * @param list  The array containing the elements we want to swap.
     * @param indexA index of the first element to be swapped.
     * @param indexB index of the second element to be swapped.
     */
    private static <T> void swapElements(List<T> list, final int indexA, final int indexB) {
        final T temp = list.get(indexA);
        list.set(indexA, list.get(indexB));
        list.set(indexB, temp);
    }
    
    /**
     * Swap two elements in an array.
     * @param array the array to operate on
     * @param indexA the index of one of the elements to be swapped
     * @param indexB the second index of the element to be swapped
     * @param <T> any object.
     */
    private static <T> void swapElements(T[] array, final int indexA, final int indexB) {
        T temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
}
