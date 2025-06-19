package baseball.model;

import java.util.Objects;

public class Result {

    private static final int WINNING_STRIKE_COUNT = 3;

    private final int strike;
    private final int ball;

    private Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Result of(int strike, int ball) {
        return new Result(strike, ball);
    }

    public boolean isWin() {
        return strike == WINNING_STRIKE_COUNT;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result result = (Result) o;
        return strike == result.strike && ball == result.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
