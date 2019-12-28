package view;

import domain.BillManager;
import domain.Menu;
import domain.Table;
import domain.TableRepository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_SEAT = "└ ₩ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println(NEW_LINE + "## 테이블 목록");
        final int size = tables.size();
        printTopLine(size);
        printTableNumbers(tables);
        printBottomLine(tables, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printTopLine(final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printBottomLine(List<Table> tables, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(printSeatYesOrNo(tables, index));
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

    public static void printOrderPage(int tableNumber) {
        System.out.println(NEW_LINE + "## 주문 내역");
        System.out.println("메뉴   수량   금액");

        Table table = TableRepository.tables()
                .stream()
                .filter(t -> t.getNumber() == tableNumber)
                .findFirst()
                .orElse(null);
        Map<Integer, List<Menu>> bill = BillManager.bill(Objects.requireNonNull(table).getMenu());

        for (String menu : BillManager.getBillPage(bill)) {
            System.out.println(menu);
        }
    }

    static void printPayPage(int tableNumber) {
        System.out.println(NEW_LINE + "## " + tableNumber + "번 테이블의 결제를 진행합니다.");
    }

    public static void printTotal(int paymentMethod, int tableNumber) {
        System.out.println(NEW_LINE + "## 최종 결제할 금액");
        Table table = TableRepository.tables()
                .stream()
                .filter(t -> t.getNumber() == tableNumber)
                .findFirst()
                .orElse(null);
        Map<Integer, List<Menu>> bill = BillManager.bill(Objects.requireNonNull(table).getMenu());

        System.out.println(BillManager.totalPayment(bill, paymentMethod) + "원");
        TableRepository.clearTable(tableNumber);
    }
}
