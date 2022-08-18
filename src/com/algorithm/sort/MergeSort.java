package com.algorithm.sort;

import java.lang.reflect.Array;

public class MergeSort<T extends Comparable<T>> extends SortAlgorithm<T> {

    @Override
    public void sort(T[] array, boolean asc) {
        time = System.currentTimeMillis();
        
        split(array, 0, array.length - 1, asc);
        
        this.display(array);
    }
    
    public void split(T[] array, int start, int end, boolean asc){
        if(start < end){
            
            int middle = (start + end) / 2;
            
            split(array, start, middle, asc);
            split(array, middle + 1, end, asc);
            
            merge(array,start,middle,end, asc);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void merge(T[] array, int start, int middle, int end, boolean asc) {
      
      int leftLength =  middle - start + 1;
      int rightLength = end - middle;  
     
      T[] leftSide =  (T[]) Array.newInstance(array.getClass().getComponentType(), leftLength);
      T[] rightSide = (T[]) Array.newInstance(array.getClass().getComponentType(), rightLength);
      
      for(int index  = 0; index < leftLength; index++ ){
          leftSide[index] = array[start + index];
      }
      
      for(int index  = 0; index < rightLength; index++ ){
          rightSide[index] = array[middle + index + 1];
      }
      
      int leftIndex = 0;
      int rightIndex = 0;
      int index = start;
      
      while(leftIndex < leftLength && rightIndex < rightLength){
          
          if((leftSide[leftIndex].compareTo(rightSide[rightIndex]) < 0) == asc){
              array[index++] = leftSide[leftIndex];
              leftIndex ++;
              continue;
          }
         
          array[index++] = rightSide[rightIndex];
          rightIndex++;
      }
      
      while(leftLength > leftIndex){
          array[index++] = leftSide[leftIndex];
          leftIndex++;
      }
      
      while(rightIndex < rightLength){
          array[index++] = rightSide[rightIndex];
          rightIndex ++;
      }
    }
}
