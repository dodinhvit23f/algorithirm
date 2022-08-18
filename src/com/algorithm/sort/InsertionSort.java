
package com.algorithm.sort;

public class InsertionSort<T extends Comparable<T>> extends SortAlgorithm<T> {

    @Override
    public void sort(T[] array, boolean asc) {

        this.time = System.currentTimeMillis();
        for (int index = 0; index < array.length; index++) {

            for (int sortedIndex = index; sortedIndex > 0; sortedIndex--) {

                int back = sortedIndex - 1;

                if ((array[sortedIndex].compareTo(array[back]) >= 0) == asc) {
                    break;
                }

                swap(array, sortedIndex, back);
            }
        }
        this.display(array);
    }

    public void pagnationSort(T[] array, int start, int end, boolean asc) {

        for (int index = start; index < end; index++) {

            for (int sortedIndex = index; sortedIndex > start; sortedIndex--) {

                int back = sortedIndex - 1;

                if ((array[sortedIndex].compareTo(array[back]) >= 0) == asc) {
                    break;
                }

                swap(array, sortedIndex, back);
            }
        }
    }
}
