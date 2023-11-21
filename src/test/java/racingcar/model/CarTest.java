package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("이름이 널이거나 범위를 벗어나면 예외 발생")
    @ValueSource(strings = {"", "가나다라마"})
    @ParameterizedTest
    void nameIsNullOrOutOfRange(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @DisplayName("무작위 값이 기준 값 4 이상일 때 전진")
    @Test
    void forwardIfRandomIsOverStandard() {
        //Given
        Car car = new Car();
        //When
        car.run(4);
        //Then
        assertEquals(1, car.getDistance());
    }

    @DisplayName("무작위 값이 기준 값 4 이하일 때 정지")
    @Test
    void stopIfRandomIsUnderStandard() {
        //Given
        Car car = new Car();
        //When
        car.run(3);
        //Then
        assertEquals(0, car.getDistance());
    }

}
