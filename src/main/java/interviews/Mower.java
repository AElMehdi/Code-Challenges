package interviews;

public class Mower {
    private final Coordinate coordinates;
    private final String direction;
    private final char[] instructions;
    private final AutoPilot autoPilot;

    public Mower(Coordinate coordinates, String direction, char[] instructions, AutoPilot autoPilot) {
        this.coordinates = coordinates;
        this.direction = direction;
        this.instructions = instructions;
        this.autoPilot = autoPilot;
    }
}
