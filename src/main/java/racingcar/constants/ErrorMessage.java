package racingcar.constants;

public final class ErrorMessage {
    public static final String TRY_NUMBER_NOT_POSITIVE = "시도할 횟수는 양수로 입력해주세요.";
    public static final String TRY_NUMBER_NOT_NUMBER = "시도할 횟수는 숫자 형태로 입력해주세요.";
    public static final String INVALID_CAR_NAMES = "자동차 이름은 두 개 이상 쉼표로 구분하여 입력해주세요.";
    public static final String CAR_NAME_LENGTH_OVER_FIVE = "자동차 이름은 5자 이하로만 가능합니다.";
    public static final String DUPLICATE_CAR_NAMES = "자동차 이름은 중복되지 않게 입력해주세요.";

    private ErrorMessage() {}
}
