import Cars.Car;
import Chess.ChessSquare;
import Planner.*;
import VendingMachine.VendingMachine;

import java.sql.Timestamp;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        //lesson1();
        //System.out.println();
        //lesson2();
        //lesson3();
        lesson4();
    }

    private static void lesson1() {
        Car car1 = new Car("Hyundai Solaris", 2005, 100);
        Car car2 = new Car("Honda Civic", 2008, 113);
        Car car3 = new Car("Москвич", 1996, 60);
        car1.setSpeed(90);
        car2.setSpeed(90);
        car3.setSpeed(80);
        TreeMap<Double, List<Car>> raceResult = Car.race(100, car1, car2, car3);
        int i = 0;
        for (var item: raceResult.entrySet()) {
            i++;
            System.out.println("Место №" + i + " отдано " + item.getValue());
            System.out.printf("Результат %.5g ч\n", item.getKey());
        }
    }

    private static void lesson2() {
        VendingMachine vm = new VendingMachine(20);
        try {
            vm.add("Lays", 50, 5).add("BonAqua", 100, 10).add("Mars", 20, 5);
            System.out.println(vm.getProductByName("BonAqua"));
            System.out.println(vm.contains());
            System.out.println("Lays " + vm.getProductByName("Lays", 10));
            System.out.println(vm.contains());
            System.out.println(vm.getProductByName("Lays"));
            System.out.println(vm.getProductByName("Lays", 10));
            System.out.println(vm.contains());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void lesson3() {
        ChessSquare square = new ChessSquare();
        System.out.println(square);
        System.out.println("Фигура из клетки a2 может пойти в " + square.availableMoves("a2"));
        System.out.println("Фигура из клетки a2 может пойти в " + square.availableMoves("a3"));
        System.out.println("Фигура из клетки a2 может пойти в " + square.availableMoves("b2"));
    }

    /**
     * Спроектировать и реализовать планировщик дел для работы с задачами разных приоритетов.
     *
     * Например:
     * Должен быть класс Задачи (общий/родительский и подтипы)
     * У задачи должно быть длительность, дедлайн, приоритет, тема, ответсвенный... - параметры на Ваше усмотрение
     * **У задачи должна быть возможность включить или выключить нотификацию на разные события, например, приближение дедлайна.
     *
     * Должен быть класс Календарь, в который можно добавлять Задачи.
     * *** При пересечении задач по времени - выводить сообщение пользователю.
     *
     * **** Должна быть возможность выгрузки Календаря в файл (тип на Ваше усмотрение)
     * **** Файл должен содержать следующие данные: id, дату добавления записи, время добавления записи, дедлай задачи, ФИО автора и др
     */
    private static void lesson4() {
        MyCalendar<Milestone> calendar = new MyCalendar<>();
        calendar.add(new Reminder(new Timestamp(System.currentTimeMillis()+ 40000L), "Поужинать"));
        calendar.add((new Meet(new Timestamp(System.currentTimeMillis()+ 200000L), "Йога", 3600)).notificationOff());
        calendar.add(new Task(new Timestamp(System.currentTimeMillis() + 200000L), "Выполнить д/з", new Timestamp(System.currentTimeMillis() + 600000L)));
        System.out.println(calendar);
        calendar.export("files/calendar.txt");
    }
}