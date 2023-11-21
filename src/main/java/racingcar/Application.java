package racingcar;

import racingcar.controller.RacingGameManager;

public class Application {
    public static void main(String[] args) {
        RacingGameManager racingGameManager = new RacingGameManager();

        racingGameManager.gameStart();
    }
}
