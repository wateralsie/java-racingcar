package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public OutputView() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printTryResult(Car car) {
        String distance = "-".repeat(car.getDistance());
        System.out.printf("%s : %s%n", car.getName(), distance);
    }

    public static void printWinners(List<String> winnerNames) {
        System.out.printf("최종 우승자 : %s", String.join(", ", winnerNames));
    }
}
