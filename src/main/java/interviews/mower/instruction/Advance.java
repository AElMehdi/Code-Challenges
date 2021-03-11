package interviews.mower.instruction;

import interviews.mower.Lawn;
import interviews.mower.Mower;

import java.util.Objects;

import static interviews.mower.instruction.InstructionLabel.A;

public class Advance implements Instruction {

    private InstructionLabel instructionLabel = A;

    private static Lawn lawn;

    public Advance(Lawn lawn) {
        Advance.lawn = lawn;
    }

    @Override
    public void executeOn(Mower mower) {
        mower.getDirection().execute(mower, lawn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advance advance = (Advance) o;

        if (instructionLabel != advance.instructionLabel) return false;
        return Objects.equals(lawn, advance.lawn);
    }

    @Override
    public int hashCode() {
        int result = instructionLabel != null ? instructionLabel.hashCode() : 0;
        result = 31 * result + (lawn != null ? lawn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Advance{" +
                "instructionLabel=" + instructionLabel +
                ", lawn=" + lawn +
                '}';
    }
}
