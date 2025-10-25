package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
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

    public int getRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void goForward() {
        distance += 1;
    }

    private String validate(String name) {
        validateNameLength(name);
        return name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 6) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_OVER_FIVE);
        }
    }
}
