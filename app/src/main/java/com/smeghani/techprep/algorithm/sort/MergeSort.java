package com.smeghani.techprep.algorithm.sort;

/**
 * Created by smeghani on 11/8/2016.
 * <p>
 * An example of merge sort. First divide the list into the smallest unit (1 element),
 * then compare each element with the adjacent list to sort and merge the two adjacent lists.
 * Finally all the elements are sorted and merged.
 * <p>
 * Time complexity of Merge sort is O(nLogn)
 */

public class MergeSort {

    /**
     * Sorts the given array using merge sort.
     *
     * @param data array that needs to be sorted
     */
    public static void sortData(Comparable[] data) {
        Comparable[] tmp = new Comparable[data.length];
        mergeSort(data, tmp, 0, data.length - 1);
    }

    private static void mergeSort(Comparable[] data, Comparable[] tmp, int left, int right) {

        if (left < right) {
            int pivot = (left + right) / 2;
            mergeSort(data, tmp, left, pivot);
            mergeSort(data, tmp, pivot + 1, right);
            merge(data, tmp, left, pivot, right);
        }
    }

    private static void merge(Comparable[] data, Comparable[] tmp, int left, int pivot, int right) {
        int i = left;
        int j = pivot + 1;
        int k = left;

        while (i <= pivot && j <= right) {
            if (data[i].compareTo(data[j]) < 0) {
                tmp[k] = data[i];
                i++;
            } else {
                tmp[k] = data[j];
                j++;
            }
            k++;
        }

        while (i <= left)    // Copy rest of first half
            tmp[k++] = data[left++];

        while (j <= right)  // Copy rest of right half
            tmp[k++] = data[right++];
    }
}
