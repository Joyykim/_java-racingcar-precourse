package racingcar;

import static utils.PrintUtils.print;

import exceptions.InvalidInputException;

public class Car implements Comparable<Car> {

    private static final int MAXIMUM_NAME_RANGE = 5;
    private static final int MINIMUM_NAME_RANGE = 1;
    public static final String DRIVE_PROGRESS = "-";

    private final String name;
    private Integer position = 0;

    public Car(String name) {
        name = trimName(name);
        validateNameRange(name);
        this.name = name;
    }

    private String trimName(String name) {
        return name.trim();
    }

    private void validateNameRange(String name){
        if (MAXIMUM_NAME_RANGE < name.length()) {
            throw new InvalidInputException();
        }
        if (MINIMUM_NAME_RANGE > name.length()) {
            throw new IllegalArgumentException();
        }
    }

    public void moveForward() {
        position += 1;
    }

    public void printStatus() {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < position; i++) {
            progress.append(DRIVE_PROGRESS);
        }
        print(name + " : " + progress);
    }

    public boolean isSamePosition(Car car) {
        return this.position.equals(car.position);
    }

    @Override
    public boolean equals(Object obj) {
        Car car;
        if (obj instanceof Car) {
            car = (Car) obj;
        } else {
            return false;
        }
        return this.name.equals(car.name) && this.position.equals(car.position);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + position.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }
}
