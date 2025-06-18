package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
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
}