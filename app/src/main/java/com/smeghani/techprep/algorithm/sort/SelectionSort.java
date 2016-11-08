package com.smeghani.techprep.algorithm.sort;

/**
 * Created by smeghani on 11/8/2016.
 *
 * selection sort is a sorting algorithm, specifically an in-place comparison sort
 *
 * The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element in the unsorted sublist,
 * exchanging (swapping) it with the leftmost unsorted element (putting it in sorted order), and moving the sublist boundaries
 * one element to the right.
 *
 * Time complexity is O(n2)
 */

public class SelectionSort {

    /**
     * Sorts the given array using selection sort.
     *
     * @param data array that needs to be sorted
     */
    public static <T extends Comparable> void sortData( T[] data) {
       int size = data.length;
       int min = -1;

        for(int i = 0; i < size - 2; i++){
            min = i;

            for (int j = i + 1; j < size - 1; j++ ){
                if (data[j].compareTo(data[min]) < 0){
                    min = j;
                }
            }

            T temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }
    }
}
