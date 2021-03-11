package interviews.mower.instruction;

import interviews.mower.Mower;

import static interviews.mower.direction.DirectionLabel.turnRight;
import static interviews.mower.instruction.InstructionLabel.D;

public class Right implements Instruction {

    private InstructionLabel instructionLabel = D;

    @Override
    public void executeOn(Mower mower) {
        mower.setDirection(turnRight(mower.getDirection()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Right right = (Right) o;

        return instructionLabel == right.instructionLabel;
    }

    @Override
    public int hashCode() {
        return instructionLabel.hashCode();
    }

    @Override
    public String toString() {
        return "Right{" +
                "instructionLabel=" + instructionLabel +
                '}';
    }
}
