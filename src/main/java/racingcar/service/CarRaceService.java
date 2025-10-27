package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Try;

public class CarRaceService {
    private final Cars cars;
    private final Try tries;

    public CarRaceService(String triesStr, List<String> carNames) {
        this.cars = Cars.from(carNames);
        this.tries = new Try(triesStr);
    }

    public void start() {
        for (int i = 0; i < tries.getNumber(); i++) {
            for (Car car: cars.getAll()) {
                car.tryToMove();
            }
        }
    }

    public List<String> getWinnerNames() {
        int maxDistance = cars.getAll().stream().mapToInt(Car::getDistance).max().orElse(0);
        return cars.getAll().stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }
}
