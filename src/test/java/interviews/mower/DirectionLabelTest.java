package interviews.mower;

import interviews.mower.direction.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static interviews.mower.direction.DirectionLabel.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.params.provider.Arguments.of;

class DirectionLabelTest {

    static Stream<Arguments> turnsRightDirectionProvider() {
        return Stream.of(
                of(new North(), East.class),
                of(new East(), South.class),
                of(new South(), West.class),
                of(new West(), North.class)
        );
    }

    @ParameterizedTest(name = "{0} to {1}")
    @MethodSource("turnsRightDirectionProvider")
    public void should_turn_right_from(Direction direction, Class<Direction> result) {
        assertThat(turnRight(direction)).isInstanceOf(result);
    }

    static Stream<Arguments> turnsLeftDirectionProvider() {
        return Stream.of(
                of(new North(), West.class),
                of(new West(), South.class),
                of(new South(), East.class),
                of(new East(), North.class)
        );
    }

    @ParameterizedTest(name = "{0} to {1}")
    @MethodSource("turnsLeftDirectionProvider")
    public void should_turn_left_from(Direction direction, Class<Direction> result) {
        assertThat(turnLeft(direction)).isInstanceOf(result);
    }

    @Test
    void should_convert_direction_label_to_its_corresponding_object() {
        assertThat(toDirection("N")).isInstanceOf(North.class);
        assertThat(toDirection("E")).isInstanceOf(East.class);
        assertThat(toDirection("S")).isInstanceOf(South.class);
        assertThat(toDirection("W")).isInstanceOf(West.class);
    }

    @Test
    void should_raise_an_exception_when_passed_wrong_input_to_convert() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> toDirection("WRONG"))
                .withMessageContaining("No enum constant");
    }

    @Test
    void should_convert_from_direction_to_its_corresponding_label() {
        assertThat(toDirectionLabel(new North())).isEqualTo(N);
        assertThat(toDirectionLabel(new East())).isEqualTo(E);
        assertThat(toDirectionLabel(new South())).isEqualTo(S);
        assertThat(toDirectionLabel(new West())).isEqualTo(W);
    }

}