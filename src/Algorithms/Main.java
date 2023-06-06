package Algorithms;

import Algorithms.homework2.HeapSort;
import Algorithms.homework3.List;
import Algorithms.homework3.SinglyLinkedList;
import Algorithms.homework4.LeftSideRedBlackTree;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //homework2();
        homework3();
        homework4();
    }

    private static void homework4(){
        Random rand = new Random();
        int min = 10, max = 99, rnd;
        LeftSideRedBlackTree tree = new LeftSideRedBlackTree();
        for (int i = 0; i < 30; i++) {
            rnd = rand.nextInt(max - min + 1) + min;
            System.out.print("Шаг " + (i+1) + ": " + rnd + " \n");
            tree.put(rnd);
            System.out.println(tree);
        }
        System.out.println("Конечное красно-черное дерево:");
        System.out.println(tree);
    }
    private static void homework3(){
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);
        sll.add(5);
        System.out.println(sll);
        sll.revert();
        System.out.println(sll);
        List list = new List();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        list.revert();
        System.out.println(list);
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
