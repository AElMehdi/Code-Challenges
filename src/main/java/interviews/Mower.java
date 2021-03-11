package interviews;

public class Mower {
    private final Coordinate coordinate;
    private final String direction;
    private final char[] instructions;
    private final AutoPilot autoPilot;

    public Mower(Coordinate coordinate, String direction, char[] instructions, AutoPilot autoPilot) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.instructions = instructions;
        this.autoPilot = autoPilot;
    }

    public void start() {
//        throw new UnsupportedOperationException();
    }
}
