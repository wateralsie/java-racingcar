package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printRoundResults(List<String> results) {
        System.out.println();
        System.out.println("실행 결과");
        for (String result: results) {
            System.out.println(result);
            System.out.println();
        }
    }

    public static void printWinners(List<String> winnerNames) {
        System.out.printf("최종 우승자 : %s", String.join(", ", winnerNames));
    }
}
