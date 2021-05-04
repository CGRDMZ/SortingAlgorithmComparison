package com.algorithmanalysis.assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SortingClass {
    public static void heapSort(Integer[] arrayToSort) {
        int size = arrayToSort.length;

        //heapify the array
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arrayToSort, size, i);
        }

        // we replace the first element of the array to the end,
        // we then heapify the array again to conserve the max heap property.
        for (int i = size - 1; i > 0; i--) {
            int temp = arrayToSort[0];
            arrayToSort[0] = arrayToSort[i];
            arrayToSort[i] = temp;

            heapify(arrayToSort, i, 0);
        }

    }

    private static void heapify(Integer[] array, int size, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && array[left] > array[largest]) {
            largest = left;
        }

        if (right < size && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != root) {
            swap(array, root, largest);
            heapify(array, size, largest);
        }

    }

    public static void printArray(Integer[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void dualPivotQuickSort(Integer[] arrayToSort) {
        dualPivotQuickSort(arrayToSort, 0, arrayToSort.length - 1);
    }

    private static void dualPivotQuickSort(Integer[] arr,
                                           int low, int high) {
        if (low < high) {
            int[] piv;
            piv = partition(arr, low, high);
            dualPivotQuickSort(arr, low, piv[0] - 1);
            dualPivotQuickSort(arr, piv[0] + 1, piv[1] - 1);
            dualPivotQuickSort(arr, piv[1] + 1, high);
        }
    }

    private static int[] partition(Integer[] arr, int low, int high) {
        if (arr[low] > arr[high])
            swap(arr, low, high);

        int j = low + 1,
                g = high - 1,
                k = low + 1,
                p = arr[low],
                q = arr[high];

        while (k <= g) {
            if (arr[k] < p) {
                swap(arr, k, j);
                j++;
            } else if (arr[k] >= q) {
                while (arr[g] > q && k < g) g--;
                swap(arr, k, g);
                g--;
                if (arr[k] < p) {
                    swap(arr, k, j);
                    j++;
                }
            }
            k++;
        }
        j--;
        g++;

        // place the pivots to the right indexes.
        swap(arr, low, j);
        swap(arr, high, g);
        // return new pivots.
        return new int[]{j, g};
    }


    public static void bucketSort(Integer[] arrayToSort, int maxVal) {
        int bucketSize = 5;
        int interval = maxVal / bucketSize;

        ArrayList<Integer>[] buckets = new ArrayList[bucketSize];

        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int j : arrayToSort) {
            int idx = j / interval;
            buckets[idx].add(j);
        }

        for (ArrayList<Integer> bucket :
                buckets) {
            Integer[] newArray = bucket.toArray(new Integer[0]);
            insertionSort(newArray);
            bucket.clear();
            for (Integer i :
                    newArray) {
                bucket.add(i);
            }
        }

        ArrayList<Integer> newArray = new ArrayList<>();
        for (ArrayList<Integer> bucket :
                buckets) {
            for (Integer i :
                    bucket) {
                newArray.add(i);
            }
        }
        Integer[] arr = newArray.toArray(new Integer[0]);
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = arr[i];
        }
    }

    private static void insertionSort(Integer[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; ++i) {
            int val = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > val) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = val;
        }
    }
}

