package com.smeghani.techprep.algorithm.search;

/**
 * Created by smeghani on 11/7/2016.
 * <p>
 * <p>
 * <p>
 * The question is, how many times can you divide N by 2 until you have 1? This is essentially saying, do a binary search (half the elements) until you found it. In a formula this would be this:
 * 1 = N / 2x
 * multiply by 2x:
 * <p>
 * 2x = N
 * now do the log2:
 * <p>
 * log2(2x)    = log2 N
 * x * log2(2) = log2 N
 * x * 1         = log2 N
 *
 */


public class BinarySearch {


    /**
     * Searches the value in provided Array using binary search.
     *
     * @param data   given array from which item needs to be sorted
     * @param target item to sort
     * @param min    left index
     * @param max    right index
     * @param T      item value
     * @return If item found or not
     */
    public static <T extends Comparable> boolean binarySearch(T[] data, T target, int min, int max) {

        boolean found = false;


        int midPoint = (min + max) / 2;

        if (data[midPoint].compareTo(target) == 0) { //base case
            found = true;
        }

        if (data[midPoint].compareTo(target) > 0) {
            found = binarySearch(data, target, min, midPoint - 1);

        } else if (data[midPoint].compareTo(target) > 0) {
            found = binarySearch(data, target, midPoint + 1, max);
        }


        return found;
    }
}
