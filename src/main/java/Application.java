import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final int EXIT_CODE = 3;
        int mainCode;

        do {
            mainCode = Pos.posOn();
        } while (mainCode != EXIT_CODE);
    }
}
