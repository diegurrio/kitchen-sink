package com.diego.kitchen.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortingUtilitiesTest {

    @Test
    public void testBubbleSortList() {
        ArrayList<Integer> thisArrayList = new ArrayList<>();
        thisArrayList.add(22);
        thisArrayList.add(33);
        thisArrayList.add(4);
        thisArrayList.add(45);
        thisArrayList.add(33);
        thisArrayList.add(78);
        thisArrayList.add(69);
        thisArrayList.add(24);
        thisArrayList.add(55);
        thisArrayList.add(105);

        SortingUtilities.bubbleSort(thisArrayList);

        // Check the array is sorted
        for (int index = 0; index < thisArrayList.size() - 1; index ++) {
            Assert.assertTrue(thisArrayList.get(index) <= thisArrayList.get(index + 1));
        }
    }

    @Test
    public void testBubbleSortArray() {
        Integer[] thisArray = new Integer[10];
        thisArray[0] = 22;
        thisArray[1] = 33;
        thisArray[2] = 4;
        thisArray[3] = 45;
        thisArray[4] = 33;
        thisArray[5] = 78;
        thisArray[6] = 69;
        thisArray[7] = 24;
        thisArray[8] = 55;
        thisArray[9] = 105;

        SortingUtilities.bubbleSort(thisArray);
        // Check the array is sorted
        for (int index = 0; index < thisArray.length - 1; index ++) {
            Assert.assertTrue(thisArray[index] <= thisArray[index + 1]);
        }
    }
}