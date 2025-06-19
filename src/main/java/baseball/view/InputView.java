package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String requestNumbers() {
        return Console.readLine();
    }

    public int requestRestartOrExit() {
        return Integer.parseInt(Console.readLine());
    }
}
