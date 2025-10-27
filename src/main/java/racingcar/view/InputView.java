package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.constants.CarRaceMessage;

public class InputView {
    public static List<String> readCarNames() {
        System.out.println(CarRaceMessage.CAR_NAMES_ENTER_PROMPT);
        return parseAndMakeList(Console.readLine());
    }

    public static String readTryNumber() {
        System.out.println(CarRaceMessage.TRY_NUMBER_ENTER_PROMPT);
        return Console.readLine();
    }

    private static List<String> parseAndMakeList(String str) {
        return Arrays.asList(str.split(","));
    }
}
