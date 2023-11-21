package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import racingcar.model.Cars;

public class RacingGameManagerTest {
    private final RacingGameManager racingGameManager = new RacingGameManager();

    @DisplayName("시도 횟수가 1보다 작거나 숫자가 아닌 경우 예외 발생")
    @ValueSource(strings = {"-1", "0"})
    @ParameterizedTest
    void tryCountIsNegativeOrZero(String tryCount) {
        assertThrows(IllegalArgumentException.class, () ->
                racingGameManager.tryCountValidation(tryCount));
    }

    @DisplayName("시도 횟수가 숫자가 아닌 경우 예외 발생")
    @Test
    void tryCountIsNotInteger() {
        assertThrows(IllegalArgumentException.class, () ->
                racingGameManager.tryCountValidation("not integer"));
    }

    @DisplayName("시도 횟수만큼 전진 메서드 호출")
    @Test
    void callMoveMethodByTryCount() {
        // Given
        int tryCount = 3;
        Cars spyCars = Mockito.spy(new Cars("test"));

        // When
        racingGameManager.repeatRun(tryCount, spyCars);

        // Then
        Mockito.verify(spyCars, times(tryCount)).runCars();
    }

}
