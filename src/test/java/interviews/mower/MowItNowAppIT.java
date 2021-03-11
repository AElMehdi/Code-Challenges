package interviews.mower;

import interviews.mower.autoPilot.AutoPilot;
import interviews.mower.autoPilot.CardinalDirectionPilot;
import interviews.mower.direction.East;
import interviews.mower.direction.North;
import interviews.mower.direction.West;
import interviews.mower.instruction.Instruction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static interviews.mower.direction.DirectionLabel.toDirection;
import static interviews.mower.instruction.InstructionLabel.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

public class MowItNowAppIT {
    private MowItNowApp mowItNowApp = new MowItNowApp();

    @Test
    void should_navigate_two_mowers_sequentially_in_a_lawn_of_5_by_5_grid() {
        Coordinate lawnTopRightCorner = new Coordinate(5, 5);
        Lawn lawn = new Lawn(lawnTopRightCorner);

        List<Instruction> firstMowerInstructions = toInstructions(asList(G, A, G, A, G, A, G, A, A), lawn);
        List<Instruction> secondMowerInstructions = toInstructions(asList(A, A, D, A, A, D, A, D, D, A), lawn);

        Coordinate firstMowerStartingPoint = new Coordinate(1, 2);
        Coordinate secondMowerStartingPoint = new Coordinate(3, 3);

        AutoPilot autoPilot = new CardinalDirectionPilot();

        Mower firstMower = new Mower(firstMowerStartingPoint, toDirection("N"), firstMowerInstructions);
        Mower secondMower = new Mower(secondMowerStartingPoint, toDirection("E"), secondMowerInstructions);


        List<Mower> mowers = asList(firstMower, secondMower);


        List<Mower> pilotedMowers = mowItNowApp.run(mowers, autoPilot);

        assertThat(pilotedMowers)
                .hasSize(2)
                .extracting("coordinate", "direction")
                .contains(
                        tuple(new Coordinate(1, 3), new North()),
                        tuple(new Coordinate(5, 1), new East()));
    }

    @Test
    void should_navigate_two_mowers_sequentially_in_a_lawn_of_2_by_2_grid_escaping_commands_x_axis() {
        Coordinate lawnTopRightCorner = new Coordinate(2, 2);
        Lawn lawn = new Lawn(lawnTopRightCorner);

        List<Instruction> firstMowerInstructions = toInstructions(asList(A, A, A), lawn);
        List<Instruction> secondMowerInstructions = toInstructions(asList(A, A, A), lawn);

        Coordinate firstMowerStartingPoint = new Coordinate(0, 1);
        Coordinate secondMowerStartingPoint = new Coordinate(2, 1);

        AutoPilot autoPilot = new CardinalDirectionPilot();

        Mower firstMower = new Mower(firstMowerStartingPoint, toDirection("W"), firstMowerInstructions);
        Mower secondMower = new Mower(secondMowerStartingPoint, toDirection("E"), secondMowerInstructions);


        List<Mower> mowers = asList(firstMower, secondMower);


        List<Mower> pilotedMowers = mowItNowApp.run(mowers, autoPilot);

        assertThat(pilotedMowers)
                .hasSize(2)
                .extracting("coordinate", "direction")
                .contains(
                        tuple(new Coordinate(0, 1), new West()),
                        tuple(new Coordinate(2, 1), new East()));
    }

}
