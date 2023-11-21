package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Cars {
    private final List<Car> cars;

    public Cars(String names) {
        this.cars = createCars(names);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> createCars(String inputNames) {
        String[] names = inputNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name.trim());
            cars.add(car);
        }
        return cars;
    }

    public void runCars() {
        for (Car car : cars) {
            car.run(generateRandomNumber());
        }
    }

    public List<Car> getWinner() {
        List<Car> winner = new ArrayList<>();
        Optional<Integer> maxDistance = getMaxDistance();

        cars.stream().filter(car -> car.getDistance() == maxDistance.orElse(0))
                .forEach(winner::add);
        return winner;
    }

    public List<Car> getCars() {
        return cars;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(Rule.MIN_NUMBER.value(), Rule.MAX_NUMBER.value());
    }

    private Optional<Integer> getMaxDistance() {
        return cars.stream().map(Car::getDistance)
                .max(Comparator.naturalOrder());
    }
}
