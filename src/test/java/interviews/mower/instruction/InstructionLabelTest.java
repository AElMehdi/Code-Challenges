package interviews.mower.instruction;

import interviews.mower.Coordinate;
import interviews.mower.Lawn;
import org.junit.jupiter.api.Test;

import static interviews.mower.instruction.InstructionLabel.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class InstructionLabelTest {

    @Test
    void should_convert_instructions_label_to_their_corresponding_object() {
        assertThat(toInstructions(asList(D, A, G), new Lawn(new Coordinate(5, 5))))
                .hasSize(3)
                .containsExactly(new Right(), new Advance(new Lawn(new Coordinate(5, 5))), new Left());
    }
}