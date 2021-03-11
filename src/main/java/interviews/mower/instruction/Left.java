package interviews.mower.instruction;

import interviews.mower.Mower;

import static interviews.mower.direction.DirectionLabel.turnLeft;
import static interviews.mower.instruction.InstructionLabel.*;

public class Left implements Instruction {

    private InstructionLabel instructionLabel = G;

    @Override
    public void executeOn(Mower mower) {
        mower.setDirection(turnLeft(mower.getDirection()));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Left left = (Left) o;

        return instructionLabel == left.instructionLabel;
    }

    @Override
    public int hashCode() {
        return instructionLabel != null ? instructionLabel.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Left{" +
                "instructionLabel=" + instructionLabel +
                '}';
    }
}
