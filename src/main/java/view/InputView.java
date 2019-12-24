package view;

import domain.Validator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static Validator validator = new Validator();

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        String input = scanner.nextLine();

        validator.isNull(input);
        try {
            int value = Integer.parseInt(input);
            return value;
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해야 합니다.");
            return inputTableNumber();
        }
    }

    public static int inputMain() {
        OutputView.printMain();
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = scanner.nextLine();

        validator.isNull(input);
        try {
            int value = Integer.parseInt(input);
            return value;
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해야 합니다.");
            return inputTableNumber();
        }
    }
}
