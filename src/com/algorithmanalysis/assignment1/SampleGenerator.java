package com.algorithmanalysis.assignment1;

import java.util.Arrays;
import java.util.Random;

public class SampleGenerator {

    public static int[] generateIncreasingArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateDecreasingArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i - 1;
        }
        return arr;
    }

    public static int[] generateRandom(int size, int max) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(max);
        }
        return arr;
    }

    public static int[] generateEqual(int size) {
        int[] arr = new int[size];
        Arrays.fill(arr, 42);
        return arr;
    }


}
