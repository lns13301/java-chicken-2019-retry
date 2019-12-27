package domain;

import java.util.InputMismatchException;

public class Validator {
    private static final int EMPTY = 0;

    public void isNull(String value) {
        if (value.length() == EMPTY) {
            throw new IllegalArgumentException("입력된 값이 Null 입니다.");
        }
    }

    public boolean isMoreThanZero(int value) {
        return value > EMPTY;
    }

    public boolean isNumberBetween(int min, int max, int value) {
        return value >= min && value <= max;
    }

    public void inputMismatchExceptionHandler(boolean bool) {
        if (!bool)  {
            throw new InputMismatchException();
        }
    }
}
