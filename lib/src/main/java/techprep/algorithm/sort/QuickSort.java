package com.smeghani.techprep.algorithm.sort;

/**
 * Created by smeghani on 11/8/2016.
 * Choose a pivot value. We take the value of the middle element as pivot value, but it can be any value, which is in range of sorted values, even if it doesn't present in the array.
 * Partition. Rearrange elements in such a way, that all elements which are lesser than the pivot go to the left part of the array and all elements greater than the pivot, go to the right part of the array. Values equal to the pivot can stay in any part of the array. Notice, that array may be divided in non-equal parts.
 * Sort both parts. Apply quicksort algorithm recursively to the left and the right parts.
 *
 * Time Complexity Averate is O(nLogn)
 * Time Complexity Worst is O(n2)
 */

public class QuickSort {

    /**
     * Sorts the given array using quick sort.
     *
     * @param data array that needs to be sorted
     */
    public static <T extends Comparable> void sortData(T[] data, int left, int right) {

        if (left < right) {
            int partitionIndex = partition(data, left, right);
            sortData(data, left, partitionIndex - 1);
            sortData(data, partitionIndex + 1, right);
        }
    }

    public static <T extends Comparable> int partition(T[] data, int left, int right) {

        T pivot = data[right];
        int pIndex = left;

        for (int i = left; i < right - 1; i++) {
            if (data[i].compareTo(pivot) <= 0) {
                T temp = data[pIndex];
                data[pIndex] = data[i];
                data[i] = temp;

                pIndex++;
            }
        }

        T temp = data[pIndex];
        data[pIndex] = data[right];
        data[right] = temp;


        return pIndex;

    }
}
