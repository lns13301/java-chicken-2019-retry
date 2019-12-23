package domain;

public class Validator {
    private static final int EMPTY = 0;

    public boolean isNull(String value) {
        return value.length() == EMPTY;
    }
}
