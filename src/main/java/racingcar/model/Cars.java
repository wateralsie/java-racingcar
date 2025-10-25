package racingcar.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constants.ErrorMessage;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars addCarsToRace(String namesStr) {
        List<String> names = getNamesFrom(namesStr);
        for (String name : names) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    private List<String> getNamesFrom(String namesStr) {
        String[] names = namesStr.split(",");
        validate(names);
        return Arrays.asList(names);
    }

    private void validate(String[] names) {
        checkMinimumCars(names);
        checkDuplicateNames(names);
    }

    private void checkMinimumCars(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAMES);
        }
    }

    private void checkDuplicateNames(String[] names) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAMES);
            }
        }
    }
}
