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

    public static void registerNewOrder(int tableNumber, int menuNumber, int menuCount) {
        Table orderTable = tables.stream().filter(table -> table.getNumber() == tableNumber).findFirst().get();
        tables.remove(orderTable);
        orderTable.isSeatEmpty(false);
        registerMenu(orderTable, menuNumber, menuCount);
        tables.add(orderTable);
    }

    private static void registerMenu(Table table, int menuNumber, int menuCount) {
        for (int i = 0; i < menuCount; i++) {
            table.addMenu(MenuRepository.addOrderMenu(menuNumber));
        }
    }

    public static List<Table> sortTables() {
        return tables.stream().sorted(Comparator.comparing(Table::getNumber)).collect(Collectors.toList());
    }
}
