package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        String input = scanner.nextLine();

        try {
            int value = Integer.parseInt(input);
            return value;
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해야 합니다.");
            return inputTableNumber();
        }
    }

    public static int printMenu() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        String input = scanner.nextLine();

        try {
            int value = Integer.parseInt(input);
            return value;
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해야 합니다.");
            return inputTableNumber();
        }
    }
}
