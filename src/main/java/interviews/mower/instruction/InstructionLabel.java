package interviews.mower.instruction;

import interviews.mower.Lawn;

import java.util.List;

import static java.util.stream.Collectors.toList;

public enum InstructionLabel {
    D,
    G,
    A;

    public static List<Instruction> toInstructions(List<InstructionLabel> instructionLabels, Lawn lawn) {
        return instructionLabels.stream()
                .map(instructionLabel -> toInstruction(instructionLabel, lawn))
                .collect(toList());
    }

    private static Instruction toInstruction(InstructionLabel instructionLabel, Lawn lawn) {
        switch (instructionLabel) {
            case D:
                return new Right();
            case G:
                return new Left();
            case A:
                return new Advance(lawn);
            default:
                throw new IllegalStateException("Unexpected value: " + instructionLabel);
        }
    }
}
