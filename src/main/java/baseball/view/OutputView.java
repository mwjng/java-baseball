package baseball.view;

public class OutputView {

    public void showBaseballGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void showInputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void showResult(int strikeCount, int ballCount) {
        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();

        if (strikeCount == 3) {
            showWinningGameMessage();
        }
    }

    private void showWinningGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
