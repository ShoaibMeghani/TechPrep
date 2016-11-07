package com.smeghani.techprep.algorithm.sort;

/**
 * Created by smeghani on 11/7/2016.
 *
 * Bubble sort has a time complexity of O(n2) in average and worst case.
 */

public class BubbleSort {

    /**
     * Sorts the array using bubble sort algorithm
     *
     * @param data the list of items needs to be sorted
     *
     * @return returns the sorted array.
     * */
    public static <T extends Comparable> T[] sortData(T[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j++]) > 0) {
                    T swap = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = swap;
                }
            }
        }
        return data;
    }


}
