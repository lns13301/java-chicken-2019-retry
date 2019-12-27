package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class Pos {
    private static final int ORDER_CODE = 1;
    private static final int PAYMENT_CODE = 2;
    private static final int EXIT_CODE = 3;

    public static int posOn() {
        final int mainNumber = InputView.inputMain();

        if (mainNumber == EXIT_CODE) {
            return EXIT_CODE;
        }
        return operatePos(mainNumber);
    }

    private static int operatePos(int mainNumber) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        if (mainNumber == ORDER_CODE) {
            return orderPos(tableNumber);
        }
        payPos(tableNumber);

        return mainNumber;
    }

    private static int orderPos(int tableNumber) {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menuNumber = InputView.inputMenu();
        final int menuCount = InputView.inputCount(menuNumber);
        TableRepository.registerNewOrder(tableNumber, menuNumber, menuCount);

        return ORDER_CODE;
    }

    private static int payPos(int tableNumber) {
        OutputView.printOrderPage(tableNumber);
        OutputView.printTotal(InputView.inputPaymentMethod(tableNumber), tableNumber);

        return PAYMENT_CODE;
    }
}
