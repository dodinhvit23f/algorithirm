
package com.algorithm.sort;

import java.lang.reflect.Array;

public class TimSort<T extends Comparable<T>> extends SortAlgorithm<T> {

    private static int MIN_MERGE = 32;

    private InsertionSort<T> insertionSort;

    public TimSort() {
        insertionSort = new InsertionSort<T>();
    }

    public TimSort(int block) {
        this();
        MIN_MERGE = block;
    }

    @Override
    public void sort(T[] array, boolean asc) {
        this.time = System.currentTimeMillis();
        
        int length = array.length;
        
        int start = 0;
        int end = MIN_MERGE * (length / MIN_MERGE);

        while (start < end) {
            int rightBoder = start + MIN_MERGE;
            insertionSort.pagnationSort(array, start, rightBoder, asc);
            start = rightBoder;
        }

        insertionSort.pagnationSort(array, start, length, asc);
        if (length < MIN_MERGE) {
            display(array);
            return;
        }
        
        int step = MIN_MERGE;

        if (step < array.length) {
            step = array.length - 1;
        }
        
        int size = MIN_MERGE;
        
        while(size < length ){
            
            for(start = 0; start < length; start = start + (size*2)){
                
                int mid = start + size - 1;
                int right = mid + 1 + size;
                
                if(right > length){
                    right = length;
                }
                
                if(mid >= right ){
                    break;
                }
                
                merge(array, start, mid, right - 1, asc);
            }
            
            size = size * 2;
        }

        display(array);
    }

    @SuppressWarnings("unchecked")
    public void merge(T[] array, int start, int mid, int end, boolean asc) {

        int leftIndex = 0;
        int leftLim = mid - start + 1;
        int rightIndex = 0;
        int rightLim = end - mid;

        T[] left = (T[]) Array.newInstance(array.getClass().getComponentType(), leftLim);
        T[] right = (T[]) Array.newInstance(array.getClass().getComponentType(), rightLim);

        for (int index = start; index <= mid; index++) {
            left[leftIndex] = array[index];
            leftIndex = leftIndex + 1;
        }

        for (int index = mid + 1; index <= end; index++) {
            right[rightIndex] = array[index];
            rightIndex = rightIndex + 1;
        }

        leftIndex = 0;
        rightIndex = 0;

        while (leftIndex < leftLim && rightIndex < rightLim) {
            if ((left[leftIndex].compareTo(right[rightIndex]) < 0) == asc) {
                array[start] = left[leftIndex];
                leftIndex = leftIndex + 1;
                start = start + 1;
                continue;
            }

            array[start] = right[rightIndex];
            rightIndex = rightIndex + 1;
            start = start + 1;
        }

        while (leftIndex < leftLim) {
            array[start] = left[leftIndex];
            leftIndex = leftIndex + 1;
            start = start + 1;
            continue;
        }

        while (rightIndex < rightLim) {
            array[start] = right[rightIndex];
            rightIndex = rightIndex + 1;
            start = start + 1;
        }

    }

}
