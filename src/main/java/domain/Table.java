package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private boolean isSeatEmpty = true;
    private List<Menu> menus = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isSeatEmpty() {
        return isSeatEmpty;
    }

    public void isSeatEmpty(boolean isSeatEmpty) {
        this.isSeatEmpty = isSeatEmpty;
    }

    public int getNumber() {
        return number;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }
}
