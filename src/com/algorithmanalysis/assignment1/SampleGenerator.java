package com.algorithmanalysis.assignment1;

import java.util.Arrays;
import java.util.Random;

public class SampleGenerator {

    public static Integer[] generateIncreasingArray(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static Integer[] generateDecreasingArray(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i - 1;
        }
        return arr;
    }

    public static Integer[] generateRandom(int size, int max) {
        Integer[] arr = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(max);
        }
        return arr;
    }

    public static Integer[] generateEqual(int size) {
        Integer[] arr = new Integer[size];
        Arrays.fill(arr, 42);
        return arr;
    }


}
