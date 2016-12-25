package com.smeghani.techprep.datastructures;

import java.util.Arrays;

/**
 * Created by smeghani on 11/11/2016.
 */

public class ListImpl<T> {


    private Object[] array;
    private int DEFAULT_SIZE = 20;
    private int count = 0;

    public ListImpl() {
        array = new Object[DEFAULT_SIZE];
    }


    //Time Complexity o(1)

    /**
     * Get the specific object
     *
     * @param position
     * @return
     */
    public T get(int position) {
        if (position >= count) {
            throw new IndexOutOfBoundsException();
        }

        return (T) array[position];
    }

    //Time Complexity o(n) if array is filled otherwise o(1)

    /**
     * Add specific object
     *
     * @param obj
     * @return
     */
    public void add(T obj) {
        if (count == array.length) {
            resizeArray();
        }

        array[count++] = obj;
    }

    //Time Complexity o(n)

    /**
     * Add specific object at given position
     *
     * @param obj
     * @return
     */
    public void add(T obj, int position) {
        if (position < count) {

            if (count + 1 == array.length) {
                resizeArray();
            }

            int tempPosition = count;

            while (tempPosition > position) {
                array[tempPosition] = array[tempPosition - 1];
                tempPosition--;
            }

            array[tempPosition] = obj;
            count++;

        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    //Time Complexity o(n)

    /**
     * Remove specific object at given position
     *
     * @param position
     * @return
     */
    public void remove(int position) {
        if (position < count) {

            while (position < count) {
                array[position] = array[position + 1];
                position++;
            }
            count--;


        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Get current element size in array
     *
     * @return current size of array
     */
    public int size() {
        return count;
    }

    private void resizeArray() {
        int size = array.length * 2;
        array = Arrays.copyOf(array, size);
    }
}
