package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10, 11})
    void 숫자가_1이상_9이하가_아니면_예외가_발생한다(int number) {
        // when & then
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1 이상 9 이하이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 9})
    void 숫자가_1이상_9이하면_올바르게_동작한다(int number) {
        // when & then
        assertDoesNotThrow(() -> new Number(number));
    }
}