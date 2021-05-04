package com.algorithmanalysis.assignment1;

public class Main {

    public static void main(String[] args) {
//	    Integer[] arr = SampleGenerator.generateDecreasingArray(150);
	    Integer[] arr = SampleGenerator.generateRandom(15000000, 150);
	    SortingClass.dualPivotQuickSort(arr);
	    SortingClass.printArray(arr);
    }
}
