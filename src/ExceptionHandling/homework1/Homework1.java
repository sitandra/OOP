package ExceptionHandling.homework1;

public class Homework1 {
    public static int sum2d(String[][] arr) { // incorrect class, if arr is not string array
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);  // out of range exception, if arr[i].length < 5
                // parse to int exception, if string is not valid
                sum += val;
            }
        }
        return sum;
    }

    /*
    Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
     */
    public void method1() {
        throw new RuntimeException("First exception");
    }

    public int method2(int a1) {
        return a1/0;
    }

    public int method3() {
        int[] array = {1,2,3};
        return array[4];
    }

    /*
    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий
    новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же
    ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При
    выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException,
    т.е. ваше.
     */
    public int[] divideArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            throw new RuntimeException("Длины массивов не равны");

        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) {
                throw new RuntimeException("Деление на ноль");
            }
            result[i] = arr1[i] / arr2[i];
        }
        return result;
    }
}
