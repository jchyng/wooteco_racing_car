package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<>();


    public void setCarList(String inputString) {
        String[] carNames = inputString.split(",");

        for (String name : carNames) {
            Car car = new Car(name.trim());
            carList.add(car);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
