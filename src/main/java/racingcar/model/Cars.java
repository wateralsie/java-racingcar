package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constants.ErrorMessage;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars from(List<String> carNames) {
        validate(carNames);
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(carList);
    }

    public List<String> getMaxDistanceNames() {
        int maxDistance = cars.stream().mapToInt(Car::getDistance).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }

    private static void validate(List<String> names) {
        validateMinimumCars(names);
        validateDuplicateNames(names);
    }

    private static void validateMinimumCars(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAMES);
        }
    }

    private static void validateDuplicateNames(List<String> names) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAMES);
            }
        }
    }

    public List<Car> getAll() {
        return Collections.unmodifiableList(cars);
    }
}
