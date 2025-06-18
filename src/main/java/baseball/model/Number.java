package baseball.model;

import java.util.Objects;

public class Number {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int number;

    public Number(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("숫자는 1 이상 9 이하이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number otherNumber = (Number) o;
        return number == otherNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
