package com.algorithmanalysis.assignment1;

import java.util.Arrays;
import java.util.HashMap;

public class SortingAlgorithmComparator {
    enum SampleType {
        EQUAL,
        RANDOM,
        INCREASING,
        DECREASING,
    }
    enum SortingAlgorithm {
        HEAP_SORT,
        DUAL_PIVOT_QUICKSORT,
        BUCKET_SORT,
    }

    public SortingAlgorithmComparator() {
    }

    public void calculatePerformance() {
        int[] sizes = new int[] {1000, 10000, 100000};
        for (SortingAlgorithm algorithm :
                SortingAlgorithm.values()) {
            System.gc();
            for (SampleType sample :
                    SampleType.values()) {
                for (int size :
                        sizes) {
                    long time = switch (sample) {
                        case EQUAL -> getRuntime(algorithm, SampleGenerator.generateEqual(size));
                        case INCREASING -> getRuntime(algorithm, SampleGenerator.generateIncreasingArray(size));
                        case DECREASING -> getRuntime(algorithm, SampleGenerator.generateDecreasingArray(size));
                        case RANDOM -> getRuntime(algorithm, SampleGenerator.generateRandom(size, 100));
                    };
                    System.out.println(algorithm + " | " + sample + " | " + size + " | time: " + time);
                }
            }
        }
//        int[] sizes = new int[] {1000, 10000, 100000};
//        for (int size :
//                sizes) {
//            Integer[] arr = new Integer[size];
//            for (SampleType type :
//                    SampleType.values()) {
//                switch (type) {
//                    case EQUAL -> {
//                        arr = SampleGenerator.generateEqual(size);
//                        long runtime = getRuntime(SortingAlgorithm.BUCKET_SORT, arr);
//                        results.put(SortingAlgorithm.BUCKET_SORT, )
//
//                    }
//                }
//            }
//        }

    }

    public long getRuntime(SortingAlgorithm algorithm, Integer[] arr) {
        switch (algorithm) {
            case HEAP_SORT -> {
                long start = System.nanoTime();
                SortingClass.heapSort(arr);
                return System.nanoTime() - start;
            }
            case BUCKET_SORT -> {
                long start = System.nanoTime();
                SortingClass.bucketSort(arr);
                return System.nanoTime() - start;
            }
            case DUAL_PIVOT_QUICKSORT -> {
                long start = System.nanoTime();
                SortingClass.dualPivotQuickSort(arr);
                return System.nanoTime() - start;
            }
        }
        return -1;
    }

}
