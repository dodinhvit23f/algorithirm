
package com.algorithm.sort;

public class HeapSort<T extends Comparable<T>> extends SortAlgorithm<T> {

    @Override
    public void sort(T[] array, boolean asc) {
        this.time = System.currentTimeMillis();
        int heapLength = array.length / 2 - 1;
        int arrayLength = array.length;
        
        for (int index = heapLength ; index >= 0 ; index--) {
            heapy(array, index, arrayLength , asc);
        }
        
        for (int index = arrayLength - 1; index > 0  ; index--){
            swap(array, 0, index);
            heapy(array, 0, index, asc);
        }

        display(array);
    }

    public void heapy(T[] array, int start, int end, boolean asc) {
        
        int leftLeave = start * 2 + 1;
        int rightLeave = start * 2 + 2;
        
        int largest = start;

        if ( leftLeave < end && (array[leftLeave].compareTo(array[largest])  > 0) == asc) {
            largest = leftLeave;
        }

        if (rightLeave < end && (array[rightLeave].compareTo(array[largest]) > 0) == asc) {
            largest = rightLeave;
        }

        if (start != largest) {
            swap(array, start, largest);
            heapy(array,largest, end, asc );
        }
        
    }
}
