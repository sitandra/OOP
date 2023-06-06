package ExceptionHandling;

import ExceptionHandling.homework1.Homework1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        homework1();
    }

    private static void homework1() {
        Homework1 hm1 = new Homework1();
        System.out.println(Arrays.toString(hm1.divideArrays(new int[]{8, 2, 8}, new int[]{2, 3, 4})));
        //System.out.println(Arrays.toString(hm1.divideArrays(new int[]{8, 2, 8}, new int[]{2, 0, 4})));
        System.out.println(Arrays.toString(hm1.divideArrays(new int[]{8, 2, 8}, new int[]{2, 0, 4, 1})));
    }


}
