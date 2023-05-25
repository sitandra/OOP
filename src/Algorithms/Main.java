package Algorithms;

import Algorithms.homework2.HeapSort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        homework2();
    }

    private static void homework2() {
        int[] arr = generateArray(10, 1, 100);
        System.out.println(Arrays.toString(arr));
        HeapSort hs = new HeapSort();
        hs.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] generateArray(int length, int min, int max) {
        int[] arr = new int[length];
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }

        return arr;
    }
}
