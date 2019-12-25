package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BillManager {
    private static final int EMPTY = 0;
    private static final int CARD = 1;
    private static final int CASH = 2;
    private static final int BULK = 10;
    private static final int DISCOUNT_AMOUNT = 10000;
    private static final String DEFAULT = "";

    public static Map<Integer, List<Menu>> bill(List<Menu> menus) {
        return menus.stream().collect(Collectors.groupingBy(Menu::getNumber));
    }

    public static int totalPayment(Map<Integer, List<Menu>> bills, int paymentMethod) {
        int toPay = EMPTY;

        while (!bills.isEmpty()) {
            int key = distinctMenu(bills);
            toPay += bills.get(key).stream().mapToInt(Menu::getPrice).reduce(Integer::sum).getAsInt();
            toPay -= chickenDiscount(bills.get(key));
            bills.remove(key);
        }

        return toPay;
    }

    private static int chickenDiscount(List<Menu> menus) {
        if (isChicken(menus)) {
            return menus.size() / BULK * DISCOUNT_AMOUNT;
        }
        return EMPTY;
    }

    private static boolean isChicken(List<Menu> menus) {
        return menus.stream().anyMatch(menu -> menu.getCategory() == Category.CHICKEN);
    }

    private static int distinctMenu(Map<Integer, List<Menu>> bills) {
        return bills.keySet().stream().findFirst().get();
    }

    public static List<String> getBillPage(Map<Integer, List<Menu>> bills) {
        List<String> billPage = new ArrayList<>();

        while (!bills.isEmpty()) {
            int key = distinctMenu(bills);
            String line = name(bills, key) + " " + size(bills, key) + " " + price(bills, key);
            billPage.add(line);
            bills.remove(key);
        }

        return billPage;
    }

    private static String name(Map<Integer, List<Menu>> bills, int key) {
        return bills.get(key).stream().map(Menu::getName).findFirst().orElse(DEFAULT);
    }

    private static int size(Map<Integer, List<Menu>> bills, int key) {
        return bills.get(key).size();
    }

    private static int price(Map<Integer, List<Menu>> bills, int key) {
        return bills.get(key).stream().map(Menu::getPrice).findFirst().orElse(EMPTY);
    }
}
