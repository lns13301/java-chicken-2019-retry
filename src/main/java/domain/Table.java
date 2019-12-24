package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<Integer, List<Menu>> bill() {
        return menus.stream().collect(Collectors.groupingBy(Menu::getNumber));
    }
}
