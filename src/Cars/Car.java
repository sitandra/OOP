package Cars;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class Car {
    private final String model;
    private final int year;
    private int price; // разумеется, в копейках
    private String color;
    private final double power;

    private boolean runState = false;
    private double speed = 0;


    public Car(String model, int year, double power) {
        this.model = model;
        this.year = year;
        //this.price = price;
        //this.color = color;
        this.power = power;
    }

    public Car setSpeed(double speed) {
        this.speed = speed;
        return this;
    }

    public void getInfo() {
        System.out.println(this);
    }

    public Car run() {
        runState = true;
        return this;
    }

    public Car stop() {
        runState = false;
        return this;
    }

    public void road(String address) {
        if (runState) System.out.println("Едем в " + address);
        else System.out.println("Авто не заведено");
    }

    private double randomSpeed() {
        Random r = new Random();
        double randomValue = -5 + 10 * r.nextDouble();
        return speed + randomValue;
    }

    private double time(double distance) {
        return distance / randomSpeed();
    }

    @Override
    public String toString() {
        return model + " " + power + " " + year;
    }

    /**
     *
     * @param distance Дистанция гонки
     * @param cars Машины, участвующие в гонке
     * @return древо по времени прохождения дистанции со списками машин
     */
    public static TreeMap<Double, List<Car>> race(double distance, Car... cars) {
        double[] times = new double[cars.length];
        double distanceChunk = distance/10;
        for (int j = 0; j < 10 ; j++) {
            for (int i = 0; i < cars.length; i++) {
                times[i] = times[i] + cars[i].time(distanceChunk);
            }
        }
        TreeMap<Double, List<Car>> treeMap = new TreeMap<>(Double::compare);
        for (int i = 0; i < cars.length; i++) {
            if (treeMap.containsKey(times[i])) {
                List<Car> list = treeMap.get(times[i]);
                list.add(cars[i]);
            } else {
                List<Car> list = new ArrayList<>();
                list.add(cars[i]);
                treeMap.put(times[i], list);
            }
        }
        return treeMap;
    }
}

