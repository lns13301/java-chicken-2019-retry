package domain;

public class Validator {
    private static final int EMPTY = 0;

    public boolean isNull(String value) {
        return value.length() == EMPTY;
    }

    public boolean isMoreThanZero(int value) {
        return value > EMPTY;
    }

    public boolean isNumberBetween(int max, int min, int value) {
        return value >= min && value <= max;
    }
}
