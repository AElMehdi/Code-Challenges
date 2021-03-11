package interviews.mower;

import interviews.mower.direction.Direction;
import interviews.mower.instruction.Instruction;

import java.util.List;
import java.util.Objects;

public class Mower {
    private Coordinate coordinate;
    private Direction direction;
    private final List<Instruction> instructions;

    public Mower(Coordinate coordinate, Direction direction, List<Instruction> instructions) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.instructions = instructions;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return Objects.equals(coordinate, mower.coordinate) &&
                Objects.equals(direction, mower.direction) &&
                Objects.equals(instructions, mower.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, direction, instructions);
    }

    @Override
    public String toString() {
        return "Mower{" +
                "coordinate=" + coordinate +
                ", direction=" + direction +
                ", instructions=" + instructions +
                '}';
    }
}
