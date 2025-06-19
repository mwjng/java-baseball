package baseball.model;

public class TargetNumbers {

    private final Numbers numbers;

    private TargetNumbers(Numbers numbers) {
        this.numbers = numbers;
    }

    public static TargetNumbers generate() {
        return new TargetNumbers(Numbers.generateRandomNumbers());
    }

    public Result evaluate(Numbers numbers) {
        return this.numbers.compareTo(numbers);
    }
}
