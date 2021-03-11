package interviews.mower;

import interviews.mower.autoPilot.CardinalDirectionPilot;
import interviews.mower.instruction.Advance;
import interviews.mower.instruction.Left;
import interviews.mower.instruction.Right;
import org.junit.jupiter.api.Test;

import static interviews.mower.direction.DirectionLabel.*;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CardinalDirectionPilotTest {

    private CardinalDirectionPilot compassPilot = new CardinalDirectionPilot();
    private Lawn lawn = new Lawn(new Coordinate(5, 5));

    @Test
    void should_turn_mower_left_when_handed_a_G_thus_change_direction_from_N_to_W() {
        Mower mower = new Mower(new Coordinate(1, 2), toDirection("N"), singletonList(new Left()));

        compassPilot.move(mower);

        assertThat(mower.getDirection().getLabel()).isEqualTo(W);
    }

    @Test
    void should_turn_mower_right_when_handed_a_D_thus_change_direction_from_E_to_S() {
        Mower mower = new Mower(new Coordinate(1, 2), toDirection("E"), singletonList(new Right()));

        compassPilot.move(mower);

        assertThat(mower.getDirection().getLabel()).isEqualTo(S);
    }

    @Test
    void should_skip_command_when_reach_lawn_limit_in_x_axis_west_side() {
        Mower mower = new Mower(new Coordinate(0, 2), toDirection("W"), singletonList(new Advance(lawn)));

        compassPilot.move(mower);

        assertThat(mower).isEqualTo(new Mower(new Coordinate(0, 2), toDirection("W"), singletonList(new Advance(lawn))));
    }

    @Test
    void should_skip_command_when_reach_lawn_limit_in_x_axis_east_side() {
        Mower mower = new Mower(new Coordinate(5, 2), toDirection("E"), singletonList(new Advance(lawn)));

        compassPilot.move(mower);

        assertThat(mower).isEqualTo(new Mower(new Coordinate(5, 2), toDirection("E"), singletonList(new Advance(lawn))));
    }


    @Test
    void should_advance_on_x_axis_east_side() {
        Mower mower = new Mower(new Coordinate(3, 4), toDirection("E"), singletonList(new Advance(lawn)));

        compassPilot.move(mower);

        assertThat(mower).isEqualTo(new Mower(new Coordinate(4, 4), toDirection("E"), singletonList(new Advance(lawn))));
    }

    @Test
    void should_advance_on_x_axis_west_side() {
        Mower mower = new Mower(new Coordinate(2, 4), toDirection("W"), singletonList(new Advance(lawn)));

        compassPilot.move(mower);

        assertThat(mower).isEqualTo(new Mower(new Coordinate(1, 4), toDirection("W"), singletonList(new Advance(lawn))));
    }

    @Test
    void should_skip_command_when_reach_lawn_limit_in_y_axis_north_side() {
        Mower mower = new Mower(new Coordinate(0, 5), toDirection("N"), singletonList(new Advance(lawn)));

        compassPilot.move(mower);

        assertThat(mower).isEqualTo(new Mower(new Coordinate(0, 5), toDirection("N"), singletonList(new Advance(lawn))));
    }

    @Test
    void should_skip_command_when_reach_lawn_limit_in_y_axis_south_side() {
        Mower mower = new Mower(new Coordinate(3, 0), toDirection("S"), singletonList(new Advance(lawn)));

        compassPilot.move(mower);

        assertThat(mower).isEqualTo(new Mower(new Coordinate(3, 0), toDirection("S"), singletonList(new Advance(lawn))));
    }

    @Test
    void should_advance_on_y_axis_north_side() {
        Mower mower = new Mower(new Coordinate(2, 4), toDirection("N"), singletonList(new Advance(lawn)));

        compassPilot.move(mower);

        assertThat(mower).isEqualTo(new Mower(new Coordinate(2, 5), toDirection("N"), singletonList(new Advance(lawn))));
    }

    @Test
    void should_advance_on_y_axis_south_side() {
        Mower mower = new Mower(new Coordinate(3, 4), toDirection("S"), singletonList(new Advance(lawn)));

        compassPilot.move(mower);

        assertThat(mower).isEqualTo(new Mower(new Coordinate(3, 3), toDirection("S"), singletonList(new Advance(lawn))));
    }
}