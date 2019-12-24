package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Table {
    private static final int EMPTY = 0;
    private static final String DEFAULT = "";
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

    public int totalPayment(Map<Integer, List<Menu>> bills) {
        int toPay = EMPTY;

        while (!bills.isEmpty()) {
            int key = distinctMenu(bills);
            toPay += bills.get(key).stream().mapToInt(menu -> menu.getPrice()).reduce((a, b) -> a + b).getAsInt();
            bills.remove(key);
        }

        return toPay;
    }

    public int distinctMenu(Map<Integer, List<Menu>> bills) {
        return bills.keySet().stream().findFirst().get();
    }

    public List<String> getBillPage(Map<Integer, List<Menu>> bills) {
        List<String> billPage = new ArrayList<>();

        while (!bills.isEmpty()) {
            int key = distinctMenu(bills);
            String line = name(bills, key) + " " + size(bills, key) + " " + price(bills, key);
            billPage.add(line);
            bills.remove(key);
        }

        return billPage;
    }

    private String name(Map<Integer, List<Menu>> bills, int key) {
        return bills.get(key).stream().map(Menu::getName).findFirst().orElse(DEFAULT);
    }

    private int size(Map<Integer, List<Menu>> bills, int key) {
        return bills.get(key).size();
    }

    private int price(Map<Integer, List<Menu>> bills, int key) {
        return bills.get(key).stream().map(Menu::getPrice).findFirst().orElse(EMPTY);
    }
}
