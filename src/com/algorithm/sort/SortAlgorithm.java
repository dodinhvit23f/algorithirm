package com.algorithm.sort;


public abstract class SortAlgorithm<T extends Comparable<T>> implements ISortAlgorithm<T>{
    
    protected long time;
    
    public void swap(T[] array,int index , int sortIndex) {
       T temp = array[index];
       array[index] = array[sortIndex];
       array[sortIndex] = temp;
    }
    
   
    protected  void display(T[] array) {
        System.out.println( String.format("Total Time: %d ", System.currentTimeMillis() - time));
		/*
		 * for(int index = 0; index < array.length; index++){
		 * System.out.print(array[index]); System.out.print(" "); }
		 */
        System.out.println();
       
    }
}
