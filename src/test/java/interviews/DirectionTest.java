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

    @Test
    public void should_go_from_W_to_N_when_turns_right() {
        Direction direction = turnRight(W);
        assertThat(direction).isEqualTo(N);
    }

    @Test
    public void should_go_from_W_to_S_when_turns_left() {
        Direction direction = turnLeft(W);
        assertThat(direction).isEqualTo(S);
    }

    @Test
    public void should_go_from_N_to_W_when_turns_left() {
        Direction direction = turnLeft(N);
        assertThat(direction).isEqualTo(W);
    }
}