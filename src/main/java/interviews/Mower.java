package interviews;

import java.util.List;
import java.util.Objects;

public class Mower {
    private Coordinate coordinate;
    private Direction direction;
    private final List<Command> commands;

    public Mower(Coordinate coordinate, Direction direction, List<Command> commands) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.commands = commands;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Command> getCommands() {
        return commands;
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
                direction == mower.direction &&
                Objects.equals(commands, mower.commands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, direction, commands);
    }

    @Override
    public String toString() {
        return "Mower{" +
                "coordinate=" + coordinate +
                ", direction=" + direction +
                ", commands=" + commands +
                '}';
    }
}
