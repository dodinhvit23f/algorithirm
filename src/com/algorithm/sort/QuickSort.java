package com.algorithm.sort;

public class QuickSort<T extends Comparable<T>> extends SortAlgorithm<T> {

    @Override
    public void sort(T[] array, boolean asc) {
        time = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1, asc);
        display(array);
    }

    private int partition(T[] arr, int low, int high, boolean asc)
    {
       T privot = arr[high];
       
       int leftIndex = low;
       
       for(int rightIndex = low; rightIndex < high; rightIndex++){
          
           if((arr[rightIndex].compareTo(privot) < 0) == asc){
               swap(arr, leftIndex, rightIndex);
               leftIndex = leftIndex + 1;
               continue;
           }
       }
       
       swap(arr, leftIndex, high);
       
      
       return leftIndex;
    }
     
    
    private void quickSort(T[] arr, int low, int high, boolean asc)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high, asc);
            
            quickSort(arr, low, pi - 1, asc);
            quickSort(arr, pi + 1, high, asc);
        }
    }


}
