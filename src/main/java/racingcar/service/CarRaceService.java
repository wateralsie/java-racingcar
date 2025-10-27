package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Round;

public class CarRaceService {
    private final Cars cars;
    private final Round round;

    public CarRaceService(String tryNumberStr, List<String> carNames) {
        this.cars = Cars.from(carNames);
        this.round = new Round(tryNumberStr);
    }

    public List<String> startAndGetProgress() {
        for (int i = 0; i < round.getTotalNumber(); i++) {
            for (Car car : cars.getAll()) {
                car.tryToMove();
            }
            round.saveStatusToLog(cars.getAll());
        }
        return round.getLogs();
    }

    public List<String> getWinnerNames() {
        return cars.getMaxDistanceNames();
    }
}
