package domain;

import java.util.*;
import java.util.stream.Collectors;

public class TableRepository {
    private static final int NEW_ORDER = 1;
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

    public static void registerNewOrder(int mainNumber, int tableNumber) {
        if (mainNumber == NEW_ORDER) {
            Table orderTable = tables.stream().filter(table -> table.getNumber() == tableNumber).findFirst().get();
            tables.remove(orderTable);
            orderTable.isSeatEmpty(false);
            tables.add(orderTable);
        }
    }

    public static List<Table> sortTables() {
        return tables.stream().sorted(Comparator.comparing(Table::getNumber)).collect(Collectors.toList());
    }
}
