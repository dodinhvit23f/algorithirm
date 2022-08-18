package com.algorithm.sort;


public class SelectionSort<T extends Comparable<T>> extends SortAlgorithm<T> {

    @Override
    public void sort(T[] array, boolean asc) {
        time = System.currentTimeMillis();
        
        int length = array.length;
        
        for (int index = 0; index < length; index++){
            
            int temp = index;
            
            for(int sortIndex = index + 1; sortIndex < length; sortIndex++){
                
                if((array[temp].compareTo(array[sortIndex]) == 1) == asc){
                    temp =  sortIndex;
                }
            }
            
            this.swap(array, index, temp);
        }
        
        this.display(array);
        
    }

}
