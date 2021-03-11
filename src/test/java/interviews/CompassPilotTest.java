package interviews;

import org.junit.jupiter.api.Test;

import static interviews.Command.*;
import static interviews.Direction.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class CompassPilotTest {

    private CompassPilot compassPilot = new CompassPilot();

    @Test
    void should_turn_mower_left_when_handed_a_G_thus_change_direction_from_N_to_W() {
        Mower mower = new Mower(null, N, asList(G));

        compassPilot.control(mower, null);

        assertThat(mower.getDirection()).isEqualTo(W);
    }
    @Test
    void should_turn_mower_right_when_handed_a_D_thus_change_direction_from_E_to_S() {
        Mower mower = new Mower(null, E, asList(D));

        compassPilot.control(mower, null);

        assertThat(mower.getDirection()).isEqualTo(S);
    }

}