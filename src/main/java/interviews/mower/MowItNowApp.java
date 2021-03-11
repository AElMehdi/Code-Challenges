package interviews.mower;

import interviews.mower.autoPilot.AutoPilot;
import interviews.mower.autoPilot.CardinalDirectionPilot;
import interviews.mower.direction.Direction;
import interviews.mower.instruction.Instruction;
import interviews.mower.instruction.InstructionLabel;

import java.util.List;

import static interviews.mower.direction.DirectionLabel.toDirection;
import static interviews.mower.instruction.InstructionLabel.*;
import static java.util.Arrays.asList;

public class MowItNowApp {

    public static final Coordinate LAWN_TOP_RIGHT_CORNER = new Coordinate(5, 5);

    public static final List<InstructionLabel> MOWER_1_INSTRUCTION_LABELS = asList(G, A, G, A, G, A, G, A, A);
    public static final List<InstructionLabel> MOWER_2_INSTRUCTION_LABELS = asList(A, A, D, A, A, D, A, D, D, A);

    public static final Coordinate MOWER_1_COORDINATE = new Coordinate(1, 2);
    public static final Coordinate MOWER_2_COORDINATE = new Coordinate(3, 3);

    public static final Direction NORTH = toDirection("N");
    public static final Direction EAST = toDirection("E");


    public static void main(String[] args) {
        // FYI: I'll start from the objects that I'm intended to generate following
        // the parsing + validation of the inputs
        Lawn lawn = new Lawn(LAWN_TOP_RIGHT_CORNER);

        List<Instruction> firstMowerInstructions = toInstructions(MOWER_1_INSTRUCTION_LABELS, lawn);
        List<Instruction> secondMowerInstructions = toInstructions(MOWER_2_INSTRUCTION_LABELS, lawn);

        Mower mower1 = new Mower(MOWER_1_COORDINATE, NORTH, firstMowerInstructions);
        Mower mower2 = new Mower(MOWER_2_COORDINATE, EAST, secondMowerInstructions);

        AutoPilot compassPilot = new CardinalDirectionPilot();

        new MowItNowApp()
                .run(asList(mower1, mower2), compassPilot)
                .forEach(System.out::println);
    }

    public List<Mower> run(List<Mower> mowers, AutoPilot autoPilot) {
        mowers.forEach(mower -> autoPilot.move(mower));
        return mowers;
    }
}
