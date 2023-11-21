package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @DisplayName("자동차 이름을 콤마로 구분하여 저장")
    @Test
    void saveCarNameByComma() {
        //Given & When
        Cars cars = new Cars("pobi, woni, jun");
        List<Car> car = cars.getCars();

        //Then
        assertEquals("pobi", car.get(0).getName());
        assertEquals("woni", car.get(1).getName());
        assertEquals("jun", car.get(2).getName());
    }

    @DisplayName("가장 긴 이동거리를 가진 차들이 우승자")
    @Test
    void winnerIsHaveLongestDistance() {
        //Given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        woni.run(4);

        Cars cars = new Cars(List.of(pobi, woni));
        List<Car> winner = cars.getWinner();

        //When & Then
        assertEquals(winner.get(0).getName(), "woni");
    }
}
