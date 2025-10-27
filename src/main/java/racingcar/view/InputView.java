package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.constants.CarRaceConstant;
import racingcar.constants.CarRaceMessage;
import racingcar.constants.ErrorMessage;

public class InputView {
    public static List<String> readCarNames() {
        System.out.println(CarRaceMessage.CAR_NAMES_ENTER_PROMPT);
        String input = Console.readLine();
        validateCarNamesString(input);
        return parseAndMakeList(input);
    }

    public static String readTryNumber() {
        System.out.println(CarRaceMessage.TRY_NUMBER_ENTER_PROMPT);
        return Console.readLine();
    }

    private static void validateCarNamesString(String str) {
        if (str.endsWith(CarRaceConstant.CAR_NAME_SEPARATOR)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_IS_BLANK);
        }
    }

    private static List<String> parseAndMakeList(String str) {
        return Arrays.asList(str.split(CarRaceConstant.CAR_NAME_SEPARATOR));
    }
}
