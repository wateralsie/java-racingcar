package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.CarRaceConstant;
import racingcar.constants.ErrorMessage;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = validate(name);
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void tryToMove() {
        if (getSpeedValue() >= CarRaceConstant.PIVOT_SPEED) {
            goForward();
        }
    }

    private int getSpeedValue() {
        return Randoms.pickNumberInRange(CarRaceConstant.MIN_SPEED, CarRaceConstant.MAX_SPEED);
    }

    private void goForward() {
        distance++;
    }

    private String validate(String name) {
        validateNameIsBlank(name);
        validateNameLength(name);
        return name;
    }

    private void validateNameIsBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_IS_BLANK);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > CarRaceConstant.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_OVER_FIVE);
        }
    }
}
