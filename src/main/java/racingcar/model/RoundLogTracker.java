package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.constants.CarRaceMessage;

public class RoundLogTracker {
    public static String formatCarsStatus(List<Car> cars) {
        return cars.stream()
                .map(RoundLogTracker::formatCarStatus)
                .collect(Collectors.joining("\n"));
    }

    private static String formatCarStatus(Car car) {
        return String.format(CarRaceMessage.CAR_STATUS_FORMAT,
                car.getName(),
                "-".repeat(car.getDistance()));
    }
}
