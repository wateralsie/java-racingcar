package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        Set<Car> cars = app.addCarsToRace(app.parse(carNames));
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tries;
        try {
            tries = Integer.parseInt(Console.readLine());
            if (tries <= 0) {
                throw new IllegalArgumentException("시도할 횟수는 양수로 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자 형태로 입력해주세요.");
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
            throw new IllegalArgumentException("자동차 이름은 두 개 이상 쉼표로 구분하여 입력해주세요.");
        }
        Set<String> uniqueNames = new LinkedHashSet<>();
        for (String name : names) {
            if (name.length() > 6) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로만 가능합니다.");
            }
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복되지 않게 입력해주세요.");
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
