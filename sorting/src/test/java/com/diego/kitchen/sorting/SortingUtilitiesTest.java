package com.diego.kitchen.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingUtilitiesTest {

    private static int NUMBER_OF_ENTRIES = 1000;

    @Test
    public void testBubbleSortList() {
        ArrayList<Integer> thisArrayList = new ArrayList<>();
        final Random random = new Random();
        for (int index = 0; index < NUMBER_OF_ENTRIES; index ++) {
            thisArrayList.add(random.nextInt());
        }

        SortingUtilities.bubbleSort(thisArrayList);

        // Check the array is sorted
        for (int index = 0; index < thisArrayList.size() - 1; index ++) {
            Assert.assertTrue(thisArrayList.get(index) <= thisArrayList.get(index + 1));
        }
    }

    @Test
    public void testBubbleSortArray() {
        Integer[] thisArray = new Integer[NUMBER_OF_ENTRIES];
        final Random random = new Random();
        for (int index = 0; index < NUMBER_OF_ENTRIES; index ++) {
            thisArray[index] = random.nextInt();
        }

        SortingUtilities.bubbleSort(thisArray);

        // Check the array is sorted
        for (int index = 0; index < thisArray.length - 1; index ++) {
            Assert.assertTrue(thisArray[index] <= thisArray[index + 1]);
        }
    }

    @Test
    public void testMergeSortArrayList() {
        List<Integer> thisArrayList = new ArrayList<>();
        final Random random = new Random();
        for (int index = 0; index < NUMBER_OF_ENTRIES; index ++) {
            thisArrayList.add(random.nextInt());
        }

        thisArrayList = SortingUtilities.mergeSort(thisArrayList);

        // Check the array is sorted
        for (int index = 0; index < thisArrayList.size() - 1; index ++) {
            Assert.assertTrue(thisArrayList.get(index) <= thisArrayList.get(index + 1));
        }
    }

    @Test
    public void testTestMergeSortArray() {
        Comparable[] thisArray = new Integer[NUMBER_OF_ENTRIES];
        final Random random = new Random();
        for (int index = 0; index < NUMBER_OF_ENTRIES; index ++) {
            thisArray[index] = random.nextInt();
        }

        thisArray = SortingUtilities.mergeSort(thisArray);

        // Check the array is sorted
        for (int index = 0; index < thisArray.length - 1; index ++) {
            Assert.assertTrue(thisArray[index].compareTo(thisArray[index + 1]) <= 0);
        }
    }

    @Test
    public void testQuickSortArrayList() {
        ArrayList<Integer> thisArrayList = new ArrayList<>();
        final Random random = new Random();
        for (int index = 0; index < NUMBER_OF_ENTRIES; index ++) {
            thisArrayList.add(random.nextInt());
        }

        SortingUtilities.quickSort(thisArrayList);

        // Check the array is sorted
        for (int index = 0; index < thisArrayList.size() - 1; index ++) {
            Assert.assertTrue(thisArrayList.get(index) <= thisArrayList.get(index + 1));
        }
    }
}