package com.algorithmanalysis.assignment1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        SortingAlgorithmComparator sac = new SortingAlgorithmComparator();
        sac.calculatePerformance();

        // uncomment to get runtime of the algorithm you want with arbitrary data.
//        long a = sac.getRuntime(SortingAlgorithmComparator.SortingAlgorithm.DUAL_PIVOT_QUICKSORT, SampleGenerator.generateIncreasingArray(100000));
//        System.out.println(a);


        // uncomment to see if the algorithm for the sort works
//        SortingClass.bucketSort(SampleGenerator.generateRandom(20, 150));
//        int[] arr = SampleGenerator.generateRandom(20, 150);
//        SortingClass.bucketSort(arr);
//        SortingClass.printArray(arr);
    }
}
