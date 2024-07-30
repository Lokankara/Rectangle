package com.homework.threads.sparrow;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApi {

    private static List<Integer> positive = new ArrayList<>();
    private static List<Integer> negative = new ArrayList<>();
    private static List<Integer> range = new ArrayList<>();
    private static List<Integer> even = new ArrayList<>();
    private static List<Integer> odd = new ArrayList<>();
    private static final Integer[] array = {7, 6, 10, -1, 4, 3, -1, 2, -6, -7, -5, 8};
    private static final Predicate<Integer> isNeg = i -> i < 0;
    private static final Predicate<Integer> isPos = i -> i > 0;
    private static final Predicate<CustomCar> fast = c -> c.getMaxSpeed() > 200;
    private static final Predicate<CustomCar> slow = fast.negate();
    private static final Predicate<Integer> isEven = i -> i % 2 == 0;
    private static final Predicate<Integer> isOdd = i -> i % 2 != 0;
    private static final BinaryOperator<Integer> accumulator = (a, b) -> a + b;
    private static final Function<CustomCar, Integer> maxSpeed = CustomCar::getMaxSpeed;
    private static final ArrayList<Integer> numberList = new ArrayList<>(List.of(array));

    public static void main(String[] args) {

        positive = collectBy(numberList, isPos);
        negative = collectBy(numberList, isNeg);
        odd = collectBy(numberList, isOdd);
        even = collectBy(numberList, isEven);

        double averagePos = average(positive);
        double averageNeg = average(negative);

        System.out.printf("positive: %s%n", positive);
        System.out.printf("negative: %s%n", negative);
        System.out.printf("odd: %s%n", odd);
        System.out.printf("even: %s%n", even);

        System.out.println("average positive = " + averagePos);
        System.out.println("average negative = " + averageNeg);

        ArrayList<CustomCar> cars = new ArrayList<>();
        cars.add(new CustomCar("BMW", "Serg", 12000, 2020, 220));
        cars.add(new CustomCar("Porsche", "Serg", 20000, 2022, 250));
        cars.add(new CustomCar("Porsche", "", 9000, 2010, 180));
        cars.add(new CustomCar("Kia", "", 3000, 2000, 120));

        List<CustomCar> sortedCarsByFastSpeed = sortBy(cars, fast);
        List<CustomCar> sortedCarsBySlowSpeed = sortBy(cars, slow);

        System.out.println(String.format("Cars which speed more than 200: %s", sortedCarsByFastSpeed));
        System.out.println(String.format("Cars which speed less than 200: %s", sortedCarsBySlowSpeed));

        range = numberList.stream().sorted().collect(Collectors.toList());
//		System.out.printf("Range number list between %d and %d: %s", averagePos, averageNeg, range);
    }

    private static List<CustomCar> sortBy(
            ArrayList<CustomCar> auto,
            Predicate<CustomCar> predicate) {
        return auto
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    private static List<Integer> collectBy(
            ArrayList<Integer> integers,
            Predicate<Integer> predicate) {
        return integers
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static double average(
            List<Integer> integers) {
        return integers
                .stream()
                .reduce(accumulator).get()
                / integers.size();
    }
}

interface Car {
    void run();
}

class CustomCar implements Car {

    private String model;
    private String owner = "";
    private int price;
    private int maxSpeed;
    private int produceYear;

    public boolean isSerg() {
        return "Serg".equals(owner) ? true : false;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProduceYear() {
        return produceYear;
    }

    public void setProduceYear(int produceYear) {
        this.produceYear = produceYear;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public CustomCar(String model, String owner, int price, int produceYear, int maxSpeed) {
        super();
        this.model = model;
        this.owner = owner;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.produceYear = produceYear;
    }

    public CustomCar() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                maxSpeed, model, owner, price, produceYear);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomCar other = (CustomCar) obj;
        return maxSpeed == other.maxSpeed
                && Objects.equals(model, other.model)
                && Objects.equals(owner, other.owner)
                && price == other.price
                && produceYear == other.produceYear;
    }


    @Override
    public String toString() {
        return String.format(
                "CustomCar [model=%s, owner=%s, price=%d, maxSpeed=%d, produceYear=%d]",
                model, owner, price, maxSpeed, produceYear);
    }

    @Override
    public void run() {
    }
}