package racingcar.view;

import java.util.List;
import racingcar.constants.CarRaceConstant;
import racingcar.constants.CarRaceMessage;

public class OutputView {

    public static void printRoundResults(List<String> results) {
        printEnter();
        System.out.println(CarRaceMessage.RESULT_TITLE);
        for (String result : results) {
            System.out.println(result);
            printEnter();
        }
    }

    public static void printWinners(List<String> winnerNames) {
        System.out.printf(CarRaceMessage.WINNER_MESSAGE_FORMAT,
                String.join(CarRaceConstant.WINNER_NAMES_DELIMITER, winnerNames));
    }

    private static void printEnter() {
        System.out.println();
    }
}
