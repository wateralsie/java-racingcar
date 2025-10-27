package racingcar.controller;

import java.util.List;
import racingcar.service.CarRaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceController {
    public static void run() {
        List<String> carNames = InputView.readCarNames();
        String triesStr = InputView.readTryNumber();

        CarRaceService carRaceService = new CarRaceService(triesStr, carNames);
        List<String> progress = carRaceService.startAndGetProgress();

        OutputView.printRoundResults(progress);
        OutputView.printWinners(carRaceService.getWinnerNames());
    }
}
