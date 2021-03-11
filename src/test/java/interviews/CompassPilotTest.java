package interviews;

import org.junit.jupiter.api.Test;

import static interviews.Command.*;
import static interviews.Direction.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class CompassPilotTest {

    @Test
    void should_mower_direction_changes_from_N_to_W_when_turned_left() {
        Mower mower = new Mower(null, N, asList(G));
        new CompassPilot().control(mower, null);

        assertThat(mower.getDirection()).isEqualTo(W);
    }
}