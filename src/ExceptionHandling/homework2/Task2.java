package ExceptionHandling.homework2;

public class Task2 {
    /*
    Если необходимо, исправьте данный код
    (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
     */
    public static void main(String[] args) {
        try {
            int d = 0;
            int[] intArray = new int[]{1,1,2,3,4,5,6};
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
