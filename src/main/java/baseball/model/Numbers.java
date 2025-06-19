package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Numbers {

    private static final int NUMBERS_SIZE = 3;
    private static final String SPLIT_DELIMITER = "";

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Numbers ofNumbers(List<Number> numbers) {
        return new Numbers(numbers);
    }

    public static Numbers ofRawString(String inputNumber) {
        try {
            List<Number> convertedNumbers = convertToNumbers(inputNumber);
            return ofNumbers(convertedNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public static Numbers generateRandomNumbers() {
        List<Number> generatedNumbers = new ArrayList<>();

        while (generatedNumbers.size() < NUMBERS_SIZE) {
            Number randomNumber = Number.generateRandomNumber();
            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
            }
        }
        return ofNumbers(generatedNumbers);
    }

    private static List<Number> convertToNumbers(String inputNumber) {
        String[] inputNumbers = inputNumber.split(SPLIT_DELIMITER);
        return Arrays.stream(inputNumbers)
                .map(Integer::parseInt)
                .map(Number::of)
                .toList();
    }

    public Result compareTo(Numbers numbers) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < NUMBERS_SIZE; i++) {
            Number currentNumber = this.numbers.get(i);

            if (numbers.hasNumberSamePosition(currentNumber, i)) {
                strikeCount++;
                continue;
            }
            if (numbers.hasNumber(currentNumber)) {
                ballCount++;
            }
        }

        return Result.of(strikeCount, ballCount);
    }

    private void validate(List<Number> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
    }

    private void validateLength(List<Number> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("3자리의 수를 입력해야 합니다.");
        }
    }

    private void validateDuplicate(List<Number> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("같은 수의 숫자가 중복되면 안됩니다.");
        }
    }

    private boolean hasDuplicate(List<Number> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
    }

    private boolean hasNumberSamePosition(Number number, int position) {
        int index = this.numbers.indexOf(number);
        return index == position;
    }

    private boolean hasNumber(Number number) {
        return this.numbers.contains(number);
    }
}
