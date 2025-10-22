package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int tries = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자 형태로 입력해주세요.");
        }
    }
}
