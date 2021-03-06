package domain;

import java.util.InputMismatchException;
import java.util.List;

public class Validator {
    private static final int EMPTY = 0;
    private static final int MAX_COUNT = 100;

    public void isNull(String value) {
        if (value.length() == EMPTY) {
            throw new IllegalArgumentException("입력된 값이 Null 입니다.");
        }
    }

    public boolean isNumberBetween(int min, int max, int value) {
        return value >= min && value <= max;
    }

    public boolean isNumberInTable(List<Table> tables, int value) {
        return tables.stream().anyMatch(table -> table.getNumber() == value);
    }

    public boolean isNumberInMenu(List<Menu> menus, int value) {
        return menus.stream().anyMatch(menu -> menu.getNumber() == value);
    }

    public boolean isTableMenuOverflow(Table table, int menuNumber, int count) {
        return count > EMPTY
                && table.getMenu().stream().filter(menu -> menu.getNumber() == menuNumber).count() + count < MAX_COUNT;
    }

  public void inputMismatchExceptionHandler(boolean bool) {
        if (!bool)  {
            throw new InputMismatchException();
        }
    }
}
