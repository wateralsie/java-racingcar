package racingcar.model;

import racingcar.constants.ErrorMessage;

public class Try {
    private final int number;

    public Try(String numberStr) {
        validate(numberStr);
        this.number = Integer.parseInt(numberStr);
    }

    public int getNumber() {
        return number;
    }

    private void validate(String numberStr) {
        validateIsNumber(numberStr);
        validatePositiveNumber(numberStr);
    }

    private void validateIsNumber(String numberStr) {
        if (!numberStr.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUMBER_NOT_NUMBER);
        }
    }

    private void validatePositiveNumber(String numberStr) {
        if (Integer.parseInt(numberStr) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUMBER_NOT_POSITIVE);
        }
    }
}
