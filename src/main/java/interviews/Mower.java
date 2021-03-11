package interviews;

public class Mower {
    private Coordinate coordinate;
    private String direction;
    private final char[] instructions;

    public Mower(Coordinate coordinate, String direction, char[] instructions) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.instructions = instructions;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getDirection() {
        return direction;
    }

    public char[] getInstructions() {
        return instructions;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
