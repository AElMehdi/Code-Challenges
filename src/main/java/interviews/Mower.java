package interviews;

import java.util.List;

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
}
