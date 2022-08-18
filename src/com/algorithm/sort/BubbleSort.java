package com.algorithm.sort;


public class BubbleSort<T extends Comparable<T>> extends SortAlgorithm<T> {
    
    @Override
    public void sort(T[] array, boolean asc) {
        
        time = System.currentTimeMillis();
        
        for (int index = 0; index < array.length; index++){
            for(int sortIndex = index + 1; sortIndex < array.length; sortIndex++){
                
                if((array[index].compareTo(array[sortIndex]) == 1) == asc){
                    this.swap(array,index, sortIndex);
                }
                
            }
        }
        
        this.display(array);
    }

}
