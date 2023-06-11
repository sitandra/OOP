package ExceptionHandling.homework3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Notebook {

    public static void main(String[] args) {
        Line line;
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("Введите, разделяя пробелом:");
                    System.out.println("Фамилия Имя Отчество Дата_рождения(\u001B[31mdd.MM.yyyy\u001B[0m) Номер_телефона(\u001B[31mчисло\u001B[0m) Пол(\u001B[31mf/m\u001B[0m)");
                    line = new Line(in.nextLine());
                    break;
                } catch (LineParseException e) {
                    System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m\n" + Arrays.toString(e.getStackTrace()));
                }
            }
        }
        try (FileWriter fileWriter = new FileWriter(line.getFileName(), true)) {
            fileWriter.write(line + "\n");
            System.out.println("Произведена запись в файл: " + line);
        } catch (Exception e) {
            System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m\n" + Arrays.toString(e.getStackTrace()));
        }
    }
}
