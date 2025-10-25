package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import racingcar.constants.CarRaceMessage;
import racingcar.constants.ErrorMessage;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();

        System.out.println(CarRaceMessage.CAR_NAMES_ENTER_PROMPT);
        String carNames = Console.readLine();
        Set<Car> cars = app.addCarsToRace(app.parse(carNames));
        System.out.println(CarRaceMessage.TRY_NUMBER_ENTER_PROMPT);
        int tries;
        try {
            tries = Integer.parseInt(Console.readLine());
            if (tries <= 0) {
                throw new IllegalArgumentException(ErrorMessage.TRY_NUMBER_NOT_POSITIVE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUMBER_NOT_NUMBER);
        }
        System.out.println("\n실행 결과");
        for (int i = 0; i < tries; i++) {
            for (Car car : cars) {
                System.out.print(car.getName() + " : ");
                int num = Randoms.pickNumberInRange(0, 9);
                if (num >= 4) {
                    car.goForward();
                }
                System.out.println("-".repeat(car.getDistance()));
            }
            System.out.println();
        }
        System.out.println("최종 우승자 : " + String.join(", ", app.getWinnerNames(cars)));
    }

    public List<String> getWinnerNames(Set<Car> cars) {
        int maxDistance = cars.stream().mapToInt(Car::getDistance).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }

    public Set<String> parse(String namesStr) {
        String[] names = namesStr.split(",");
        if (names.length < 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAMES);
        }
        Set<String> uniqueNames = new LinkedHashSet<>();
        for (String name : names) {
            if (name.length() > 6) {
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_OVER_FIVE);
            }
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAMES);
            }
        }
        return uniqueNames;
    }

    public Set<Car> addCarsToRace(Set<String> names) {
        Set<Car> cars = new LinkedHashSet<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
