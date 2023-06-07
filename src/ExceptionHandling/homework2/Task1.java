package ExceptionHandling.homework2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    /*
    Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению
    приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
     */
    public static void main(String[] args) {
        Float f = null;
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("Введите дробное число типа float:");
                    f = in.nextFloat();
                    break;
                } catch (InputMismatchException e) {
                    in.nextLine();
                    System.out.println("Некорректный ввод!");
                } catch (Exception e) {
                    throw new RuntimeException("Непредвиденная ошибка, число не получено!", e);
                }
            }
            System.out.println("Победа! " + f);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " " + Arrays.toString(e.getStackTrace()));
        }
    }
}
