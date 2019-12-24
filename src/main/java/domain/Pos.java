package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class Pos {
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
        TableRepository.registerNewOrder(mainNumber, tableNumber);

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menuNumber = InputView.inputMenu();
        final int menuCount = InputView.inputCount();

        return mainNumber;
    }
}
