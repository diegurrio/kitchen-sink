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
     * Sort an array using quickSort
     * @param array The array to be sorted
     * @param <T> Any object that implements the comparable interface
     */
    public static <T extends Comparable> void quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Private recursive method driver
     * @param array the array to be sorted
     * @param lowerIndex the lower index of the partition to be sorted
     * @param highIndex the higher index of the partition to be sorted
     * @param <T> Any object that implements comparable
     */
    private static <T extends Comparable> void quickSort(T[] array, final int lowerIndex, final int highIndex) {
        if (lowerIndex >= highIndex) {
            return;
        }

        final int partitionIndex = partition(array, lowerIndex, highIndex);
        quickSort(array, lowerIndex, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, highIndex);
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

    private static <T extends Comparable<? super T>> int partition(T[] array, final int lowerIndex, final int higherIndex) {

        // We partitioned the array by moving all elements that are higher than the pivot to the right of the array
        // and those lower to the left of it.
        final T pivotValue = array[higherIndex]; // Use the last element on the partition as the pivot
        int partitionedIndex = lowerIndex;

        for (int index = lowerIndex; index < higherIndex; index++) {
            if (pivotValue.compareTo(array[index]) > 0) {
                swapElements(array, partitionedIndex, index);
                partitionedIndex++;
            }
        }

        // Finally put the pivot in its place.
        swapElements(array, higherIndex, partitionedIndex);
        return partitionedIndex;
    }

    /**
     * Sort a list using the cycle sort algorithm
     * @param list The list to be sorted
     * @param <T> Any object that implements the comparable interface.
     */
    public static <T extends Comparable> void cycleSort(@NonNull final List<T> list) {

        for (int cycleStart = 0; cycleStart < list.size(); cycleStart ++) {

            T item = list.get(cycleStart);

            int itemPosition = cycleStart;
            for (int i = cycleStart + 1; i < list.size(); i++) {
                if (list.get(i).compareTo(item) < 0) {
                    itemPosition++;
                }
            }

            // If the item is not already in it's position
            if (cycleStart != itemPosition) {

                // Check for duplicates
                while (item.equals(list.get(itemPosition))) {
                    itemPosition++;
                }

                // Put it there.
                if (itemPosition != cycleStart) {
                    T temp = item;
                    item = list.get(itemPosition);
                    list.set(itemPosition, temp);
                }

                // Check the rest of the cycle.
                while (cycleStart != itemPosition) {
                    itemPosition = cycleStart;

                    // Find position
                    for (int i = cycleStart + 1; i < list.size(); i++) {
                        if (list.get(i).compareTo(item) < 0) {
                            itemPosition++;
                        }
                    }

                    // Check for duplicates
                    while (item.equals(list.get(itemPosition))) {
                        itemPosition++;
                    }

                    // swap
                    if (!item.equals(list.get(itemPosition))) {
                        T temp = item;
                        item = list.get(itemPosition);
                        list.set(itemPosition, temp);
                    }
                }
            }
        }
    }

    /**
     * Sort a list using the cycle sort algorithm
     * @param array the array to be sorted
     * @param <T> Any object that implements the comparable interface.
     */
    public static <T extends Comparable> void cycleSort(@NonNull final T[] array) {

        // Process all of the elements on the array and find their position in the
        // array is they were sorted.
        for (int cycleStart = 0; cycleStart < array.length; cycleStart++) {
            T item = array[cycleStart];

            // Find the sorted position item in the array. We init the position
            // of the item to that of the cycle because once an item is swapped we know
            // it will remain there forever, so we skip going over items we know are good.
            int itemPosition = cycleStart;
            for (int index = cycleStart + 1; index < array.length; index++) {
                if (item.compareTo(array[index]) > 0) {
                    itemPosition++;
                }
            }

            // If the item is not already on its rightful position.
            if (cycleStart != itemPosition) {

                // Check for duplicates and adjust the position.
                while (item.equals(array[itemPosition])) {
                    itemPosition++;
                }

                // Now that we know its final position swap the item. We first check
                // if the item is not already there because we're going to do a soft swap.
                // We're going to put item where it needs to go, and we're going to set item
                // to be the value we just wrote over. We're then going to find the position
                // of that item.
                if (!item.equals(array[itemPosition])) {
                    T temp = array[itemPosition];
                    array[itemPosition] = item;
                    item = temp;
                }

                // Find the position of the new item by checking if there are any cycles left
                // for the current value of cycleStart.
                while (itemPosition != cycleStart) {

                    // Find the position of item in the array. We use cycle start instead of 0
                    // because we can skip items that are already placed.
                    itemPosition = cycleStart;
                    for (int index = cycleStart + 1; index < array.length; index++) {
                        if (item.compareTo(array[index]) > 0) {
                            itemPosition++;
                        }
                    }

                    // Check for duplicates and adjust itemPosition.
                    while (item.equals(array[itemPosition])) {
                        itemPosition++;
                    }

                    // Swap the item
                    if (!item.equals(array[itemPosition])) {
                        T temp = array[itemPosition];
                        array[itemPosition] = item;
                        item = temp;
                    }
                }

            }
        }
    }
}
