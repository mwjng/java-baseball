package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234", "12345"})
    void 숫자가_3자리가_아니면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> Numbers.ofRawString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리의 수를 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ab", " a ", "abc", "a  ", "   "})
    void 숫자가_아닌_값을_입력하면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> Numbers.ofRawString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력할 수 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"112", "222", "233", "525"})
    void 같은_숫자가_중복되면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> Numbers.ofRawString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("같은 수의 숫자가 중복되면 안됩니다.");
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForComparison")
    void 숫자_비교_테스트(Numbers targetNumbers, Numbers numbers, Result expectedResult) {
        // when
        Result result = targetNumbers.compareTo(numbers);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideNumbersForComparison() {
        return Stream.of(
                arguments(Numbers.ofRawString("123"), Numbers.ofRawString("123"), Result.of(3, 0)),
                arguments(Numbers.ofRawString("123"), Numbers.ofRawString("132"), Result.of(1, 2)),
                arguments(Numbers.ofRawString("123"), Numbers.ofRawString("456"), Result.of(0, 0)),
                arguments(Numbers.ofRawString("123"), Numbers.ofRawString("231"), Result.of(0, 3))
        );
    }
}