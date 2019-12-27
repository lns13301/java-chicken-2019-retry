package view;

import com.sun.org.apache.bcel.internal.generic.NEW;
import domain.MenuRepository;
import domain.TableRepository;
import domain.Validator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final int MENU_MIN = 1;
    private static final int MENU_MAX = 3;
    private static final String NEW_LINE = "\n";
    private static final Scanner scanner = new Scanner(System.in);
    private static Validator validator = new Validator();

    public static int inputTableNumber() {
        System.out.println(NEW_LINE + "## 주문할 테이블을 선택하세요.");
        String input = scanner.nextLine();

        validator.isNull(input);
        try {
            int value = Integer.parseInt(input);
            validator.inputMismatchExceptionHandler(validator.isNumberInTable(TableRepository.tables(), value));
            return value;
        } catch (NumberFormatException e) {
            System.out.println(NEW_LINE + "숫자를 입력해야 합니다.");
        } catch (InputMismatchException e) {
            System.out.println(NEW_LINE + "해당 테이블 번호는 존재하지 않습니다.");
        }
        return inputTableNumber();
    }

    public static int inputMain() {
        OutputView.printMain();
        System.out.println(NEW_LINE + "## 원하는 기능을 선택하세요.");
        String input = scanner.nextLine();

        validator.isNull(input);
        try {
            int value = Integer.parseInt(input);
            validator.inputMismatchExceptionHandler(validator.isNumberBetween(MENU_MIN, MENU_MAX, value));
            return value;
        } catch (NumberFormatException e) {
            System.out.println(NEW_LINE + "숫자를 입력해야 합니다.");
        } catch (InputMismatchException e) {
            System.out.println(NEW_LINE + "입력된 값이 1, 2, 3 중 하나가 아닙니다.");
        }
        return inputMain();
    }

    public static int inputMenu() {
        System.out.println(NEW_LINE + "## 등록할 메뉴를 선택하세요.");
        String input = scanner.nextLine();

        validator.isNull(input);
        try {
            int value = Integer.parseInt(input);
            validator.inputMismatchExceptionHandler(validator.isNumberInMenu(MenuRepository.menus(), value));
            return value;
        } catch (NumberFormatException e) {
            System.out.println(NEW_LINE + "숫자를 입력해야 합니다.");
        } catch (InputMismatchException e) {
            System.out.println(NEW_LINE + "해당 번호의 메뉴는 존재하지 않습니다.");
        }
        return inputMenu();
    }

    public static int inputCount() {
        System.out.println(NEW_LINE + "## 메뉴의 수량을 입력하세요.");
        String input = scanner.nextLine();

        validator.isNull(input);
        try {
            int value = Integer.parseInt(input);
            return value;
        } catch (NumberFormatException e) {
            System.out.println(NEW_LINE + "숫자를 입력해야 합니다.");
            return inputCount();
        }
    }

    public static int inputPaymentMethod(int tableNumber) {
        OutputView.printPayPage(tableNumber);
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        String input = scanner.nextLine();

        validator.isNull(input);
        try {
            int value = Integer.parseInt(input);
            return value;
        } catch (NumberFormatException e) {
            System.out.println(NEW_LINE + "숫자를 입력해야 합니다.");
            return inputCount();
        }
    }
}
