package ExceptionHandling.homework3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Line {
    private final String surname;
    private final String name;
    private final String patronymic;
    private final Date birthdate;
    private final long phoneNumber;
    private final char gender;

    public static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Line(String surname, String name, String patronymic, Date birthdate, long phoneNumber, char gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public Line(String text) throws LineParseException {
        if (text == null || text.isEmpty())
            throw new LineParseException("Запись не может быть пустой");
        String[] words = text.split(" ");
        if (words.length != 6)
            throw new LineParseException("Неверное количество слов в строке");
        for (String word: words) {
            if (word.isEmpty())
                throw new LineParseException("Данные не заполнены");
        }
        if (isInvalidName(words[0]))
            throw new LineParseException("Некорректная фамилия");
        if (isInvalidName(words[1]))
            throw new LineParseException("Некорректное имя");
        if (isInvalidName(words[2]))
            throw new LineParseException("Некорректное отчество");
        this.surname = words[0];
        this.name = words[1];
        this.patronymic = words[2];
        try {
            this.birthdate = dateFormat.parse(words[3]);
        } catch (ParseException e) {
            throw new LineParseException("Некорректная дата рождения", e);
        }
        Date currentDate = new Date();
        Date minDate = new Date(currentDate.getTime() - (long) 150*365*24*60*60*1000);
        if (this.birthdate.after(currentDate) || this.birthdate.before(minDate))
            throw new LineParseException("Дата рождения вне допустимого диапазона");
        try {
            this.phoneNumber = Long.parseLong(words[4]);
        } catch(Exception e) {
            throw new LineParseException("Некорректный номер телефона");
        }
        if (!words[5].equals("f") && !words[5].equals("m"))
            throw new LineParseException("Некорректный пол");
        this.gender = words[5].charAt(0);
    }

    private static boolean isInvalidName(String str) {
        // Проверяем, что первый символ является заглавной буквой
        if (!Character.isUpperCase(str.charAt(0))) {
            return true;
        }
        // Проверяем, что все символы являются буквами или дефисами
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetter(c) && c != '-') {
                return true;
            }
        }
        return false;
    }

    public String getFileName() {
        return surname + ".txt";
    }

    @Override
    public String toString() {
        return "<" + surname + ">" +
                "<" + name + ">" +
                "<" + patronymic + ">" +
                "<" + dateFormat.format(birthdate) + ">" +
                "<" + phoneNumber + ">" +
                "<" + gender + ">";
    }
}
