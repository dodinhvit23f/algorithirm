package com.algorithm.sort;


public interface ISortAlgorithm <T extends Comparable<T>>{
    public void sort(T[] array, boolean asc);
    public void swap(T[] array,int index , int sortIndex);
}
