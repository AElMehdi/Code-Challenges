package interviews;

import org.junit.jupiter.api.Test;

import static interviews.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    public void should_go_from_N_to_W_when_turns_right() {
        Direction direction = turnRight(N);
        assertThat(direction).isEqualTo(E);
    }

}