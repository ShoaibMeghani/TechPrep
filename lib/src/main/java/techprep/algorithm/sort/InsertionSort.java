package com.smeghani.techprep.algorithm.sort;

/**
 * Created by smeghani on 11/8/2016.
 */

public class InsertionSort {

    public static <T extends Comparable> T[] sortData(T[] data) {
        for (int i = 1; i < data.length - 1; i++) {

            T value = data[i];
            int hole = i;

            while(hole > 0 && data[hole - 1].compareTo(value) > 0){
                data[hole] = data[hole -1];
                hole = hole - 1;
            }

            data[hole] = value;


        }
        return data;
    }


}
