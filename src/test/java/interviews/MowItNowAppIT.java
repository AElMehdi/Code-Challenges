package interviews;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class MowItNowAppIT {
    private MowItNowApp mowerNavigator = new MowItNowApp();


    //Define how the lawn construct
    //write a parametrized test representing the Feature
    //Build from there the Objects and stuff to make it work

    //    Read from a file (just enter the values without file reading for now)
    //    Check if the values are there


    @Test
    void should_navigate_two_mowers_sequentially_in_a_lawn_of_5_by_5_grid() {
        Coordinate lawnTopRightCorner = new Coordinate(5, 5);
        Lawn lawn = new Lawn(lawnTopRightCorner);

        char[] firstMowerInstructions = {'G', 'A', 'G', 'A', 'G', 'A', 'G', 'A', 'A'};
        char[] secondMowerInstructions = {'A', 'A', 'D', 'A', 'A', 'D', 'A', 'D', 'D', 'A'};

        Coordinate firstMowerCoordinate = new Coordinate(1, 2);
        Coordinate secondMowerCoordinate = new Coordinate(3, 3);

        AutoPilot autoPilot = new CardinalDirectionAutoPilot(lawn);

        Mower firstMower = new Mower(firstMowerCoordinate, "N", firstMowerInstructions, autoPilot);
        Mower secondMower = new Mower(secondMowerCoordinate, "E", secondMowerInstructions, autoPilot);


        List<Mower> mowers = asList(firstMower, secondMower);


        List<Mower> mowersAfterRunning = mowerNavigator.run(lawn, mowers);

        assertThat(mowersAfterRunning)
                .hasSize(2)
                .flatExtracting("x", "y", "direction")
                .contains(
                        new Mower(firstMowerCoordinate, "N", firstMowerInstructions, autoPilot),
                        new Mower(secondMowerCoordinate, "E", firstMowerInstructions, autoPilot));
    }
}
