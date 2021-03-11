package interviews;

import org.junit.jupiter.api.Test;

import static interviews.Command.*;
import static interviews.Command.D;
import static interviews.Command.G;
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

    @Test
    void should_skip_command_when_reach_lawn_limit_in_x_axis_west_side() {
        Mower mower = new Mower(new Coordinate(0, 2), W, asList(A));

        compassPilot.control(mower, new Lawn(new Coordinate(5, 5)));

        assertThat(mower).isEqualTo(new Mower(new Coordinate(0, 2), W, asList(A)));
    }

    @Test
    void should_skip_command_when_reach_lawn_limit_in_x_axis_east_side() {
        Mower mower = new Mower(new Coordinate(5, 2), E, asList(A));

        compassPilot.control(mower, new Lawn(new Coordinate(5, 5)));

        assertThat(mower).isEqualTo(new Mower(new Coordinate(5, 2), E, asList(A)));
    }

    @Test
    void should_skip_command_when_reach_lawn_limit_in_y_axis_north_side() {
        Mower mower = new Mower(new Coordinate(0, 5), N, asList(A));

        compassPilot.control(mower, new Lawn(new Coordinate(5, 5)));

        assertThat(mower).isEqualTo(new Mower(new Coordinate(0, 5), N, asList(A)));
    }

    @Test
    void should_skip_command_when_reach_lawn_limit_in_y_axis_south_side() {
        Mower mower = new Mower(new Coordinate(3, 0), S, asList(A));

        compassPilot.control(mower, new Lawn(new Coordinate(5, 5)));

        assertThat(mower).isEqualTo(new Mower(new Coordinate(3, 0), S, asList(A)));
    }
}