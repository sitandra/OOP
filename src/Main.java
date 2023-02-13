import Cars.Car;

import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        lesson1();
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
}