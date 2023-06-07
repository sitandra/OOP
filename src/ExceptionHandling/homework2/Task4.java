package ExceptionHandling.homework2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task4 {
    /*
     * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
     * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
     */

    public static void main(String[] args) {
        String text;
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите строку:");
            text = in.nextLine();
            if (text.isEmpty())
                throw new RuntimeException("Пустая строка");
            System.out.println("OK");
        } catch (RuntimeException e) {
            System.out.println("Пустые строки вводить нельзя");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " " + Arrays.toString(e.getStackTrace())
                    + " " + e.getCause().getMessage());
        }
    }

}
