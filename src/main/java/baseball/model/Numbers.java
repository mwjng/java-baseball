package baseball.model;

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

    public static Numbers from(String inputNumber) {
        try {
            List<Number> convertedNumbers = convertToNumbers(inputNumber);
            return new Numbers(convertedNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static List<Number> convertToNumbers(String inputNumber) {
        String[] inputNumbers = inputNumber.split(SPLIT_DELIMITER);
        return Arrays.stream(inputNumbers)
                .map(Integer::parseInt)
                .map(Number::new)
                .toList();
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
}
