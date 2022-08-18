package com.algorithm.sort;

public class Main {

	public static void main(String[] args) {
		boolean asc = true;
		int lim = 10000000;
		
		TestAlgorithm bubble = new TestAlgorithm(new BubbleSort<>(), lim, asc);
		bubble.test();
		TestAlgorithm insertion = new TestAlgorithm(new InsertionSort<>(), lim, asc);
		insertion.test();
		TestAlgorithm selection = new TestAlgorithm(new SelectionSort<>(), lim, asc);
		selection.test();
		TestAlgorithm merge = new TestAlgorithm(new MergeSort<>(), lim, asc);
		merge.test();
		TestAlgorithm heap = new TestAlgorithm(new HeapSort<>(), lim, asc);
		heap.test();
		TestAlgorithm quick = new TestAlgorithm(new QuickSort<>(), lim, asc);
		quick.test();
		TestAlgorithm tim = new TestAlgorithm(new TimSort<>(), lim, asc);
		tim.test();
		tim.saveResult();
		

	}

}
