package interviews.mower.instruction;

import interviews.mower.Mower;

@FunctionalInterface
public interface Instruction {
    void executeOn(Mower mower);
}
