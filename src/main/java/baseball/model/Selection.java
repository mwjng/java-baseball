package baseball.model;

import java.util.Arrays;

public enum Selection {

    RESTART(1, "재시작"),
    EXIT(2, "종료");

    private final int code;
    private final String description;

    Selection(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Selection from(int input) {
        return Arrays.stream(values())
                .filter(selection -> selection.code == input)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("잘못된 입력값입니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."));
    }
}
