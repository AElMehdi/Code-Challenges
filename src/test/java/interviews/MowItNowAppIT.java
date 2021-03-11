package interviews;

import org.junit.jupiter.api.Test;

import java.util.List;

import static interviews.Command.*;
import static interviews.Direction.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

public class MowItNowAppIT {
    private MowItNowApp mowItNowApp = new MowItNowApp();


    //Define how the lawn construct
    //write a parametrized test representing the Feature
    //Build from there the Objects and stuff to make it work

    //    Read from a file (just enter the values without file reading for now)
    //    Check if the values are there


    @Test
    void should_navigate_two_mowers_sequentially_in_a_lawn_of_5_by_5_grid() {
        Coordinate lawnTopRightCorner = new Coordinate(5, 5);
        Lawn lawn = new Lawn(lawnTopRightCorner);

        List<Command> firstMowerCommands = asList(G, A, G, A, G, A, G, A, A);
        List<Command> secondMowerCommands = asList(A, A, D, A, A, D, A, D, D, A);

        Coordinate firstMowerCoordinate = new Coordinate(1, 2);
        Coordinate secondMowerCoordinate = new Coordinate(3, 3);

        AutoPilot autoPilot = new CompassPilot();

        Mower firstMower = new Mower(firstMowerCoordinate, N, firstMowerCommands);
        Mower secondMower = new Mower(secondMowerCoordinate, E, secondMowerCommands);


        List<Mower> mowers = asList(firstMower, secondMower);


        List<Mower> pilotedMowers = mowItNowApp.run(lawn, mowers, autoPilot);

        assertThat(pilotedMowers)
                .hasSize(2)
                .extracting("coordinate", "direction")
                .contains(
                        tuple(new Coordinate(1, 3), N),
                        tuple(new Coordinate(5, 1), E));
    }
}
