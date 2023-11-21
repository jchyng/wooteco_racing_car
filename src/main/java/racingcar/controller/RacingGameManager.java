package racingcar.controller;

import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.model.Cars;

public class RacingGameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void gameStart() {
        String names = inputView.enterCarNames();
        Cars cars = new Cars(names);

        String inputTryCount = inputView.enterTryCount();
        int tryCount = getTryCount(inputTryCount);

        repeatRun(tryCount, cars);
        outputView.printWinner(cars.getWinner());
    }

    void repeatRun(int tryCount, Cars cars) {
        System.out.println("실행 결과");

        while (tryCount > 0) {
            cars.runCars();
            outputView.printProgressStatus(cars.getCars());
            tryCount--;
        }
    }

    void tryCountValidation(String tryCount) {
        if (!isNumeric(tryCount)) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(tryCount) < 1) {
            throw new IllegalArgumentException();
        }
    }

    private int getTryCount(String tryCount) {
        tryCountValidation(tryCount);
        return convertStringToInt(tryCount);
    }

    private int convertStringToInt(String tryCount) {
        return Integer.parseInt(tryCount);
    }

    private boolean isNumeric(String inputString) {
        return inputString.matches("-?\\d+");
    }
}
