package view;

import domain.Menu;
import domain.Table;
import domain.TableRepository;

import java.util.List;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_SEAT = "└ ₩ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println(NEW_LINE + "## 테이블 목록");
        final int size = tables.size();
        printTopLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printTopLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printBottomLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(printSeatYesOrNo(TableRepository.tables(), index));
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static String printSeatYesOrNo(List<Table> table, int index) {
        if (table.get(index).isSeatEmpty()) {
            return BOTTOM_LINE;
        }
        return BOTTOM_LINE_SEAT;
    }

    static void printMain() {
        System.out.println(NEW_LINE + "## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }
}
