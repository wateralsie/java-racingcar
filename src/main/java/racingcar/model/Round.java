package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.constants.CarRaceConstant;
import racingcar.constants.ErrorMessage;

public class Round {
    private final int totalNumber;
    private final List<String> logs;

    public Round(String numberStr) {
        validateTotalNumber(numberStr);
        this.totalNumber = Integer.parseInt(numberStr);
        this.logs = new ArrayList<>();
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public List<String> getLogs() {
        return new ArrayList<>(logs);
    }

    public void saveStatusToLogs(List<Car> cars) {
        String log = RoundLogTracker.formatCarsStatus(cars);
        logs.add(log);
    }

    private static void validateTotalNumber(String numberStr) {
        validateIsNumber(numberStr);
        validatePositiveNumber(numberStr);
    }

    private static void validateIsNumber(String numberStr) {
        if (numberStr.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUMBER_NOT_NUMBER);
        }
        if (!numberStr.matches(CarRaceConstant.ONLY_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUMBER_NOT_NUMBER);
        }
    }

    private static void validatePositiveNumber(String numberStr) {
        if (Integer.parseInt(numberStr) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUMBER_NOT_POSITIVE);
        }
    }

}
