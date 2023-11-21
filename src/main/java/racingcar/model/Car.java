package racingcar.model;

public class Car {
    private String name;
    private int distance = 0;

    public Car() {
    }

    public Car(String name) {
        lengthValidation(name);
        this.name = name;
    }

    public void run(int number) {
        if (isMove(number)) {
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private void lengthValidation(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        } else if (name.length() < Rule.MIN_LENGTH.value() || name.length() > Rule.MAX_LENGTH.value()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isMove(int number) {
        return number >= Rule.THRESHOLD.value();
    }
}
