package baseball;

import baseball.model.Numbers;
import baseball.model.Result;
import baseball.model.Selection;
import baseball.model.TargetNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.showBaseballGameStartMessage();
        do {
            playGame();
        } while (isContinue());
    }

    private void playGame() {
        TargetNumbers targetNumbers = TargetNumbers.generate();
        playRound(targetNumbers);
    }

    private void playRound(TargetNumbers targetNumbers) {
        Result result;
        do {
            outputView.showInputNumberMessage();

            Numbers numbers = getNumbersFromUserInput();
            result = targetNumbers.evaluate(numbers);

            outputView.showResult(result.getStrike(), result.getBall());
        } while (result.isWin());
    }

    private Numbers getNumbersFromUserInput() {
        String inputNumbers = inputView.requestNumbers();
        return Numbers.ofRawString(inputNumbers);
    }

    private boolean isContinue() {
        int selectedNumber = inputView.requestRestartOrExit();
        return Selection.RESTART == Selection.from(selectedNumber);
    }
}
