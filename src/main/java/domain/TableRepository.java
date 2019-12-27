package domain;

import java.util.*;
import java.util.stream.Collectors;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    static void registerNewOrder(int tableNumber, int menuNumber, int menuCount) {
        Table table = findTable(tableNumber);
        tables.remove(table);
        table.isSeatEmpty(false);
        registerMenu(table, menuNumber, menuCount);
        tables.add(table);
    }

    private static void registerMenu(Table table, int menuNumber, int menuCount) {
        for (int i = 0; i < menuCount; i++) {
            table.addMenu(MenuRepository.addOrderMenu(menuNumber));
        }
    }

    public static void clearTable(int tableNumber) {
        Table table = findTable(tableNumber);
        tables.remove(table);
        tables.add(new Table(tableNumber));
    }

    public static List<Table> sortTables() {
        return tables.stream().sorted(Comparator.comparing(Table::getNumber)).collect(Collectors.toList());
    }

    public static Table findTable(int tableNumber) {
        return tables.stream().filter(table -> table.getNumber() == tableNumber).findFirst().orElse(null);
    }
}
