package interviews;

public enum Direction {
    N(0),
    E(1),
    S(2),
    W(3);

    private int index;

    Direction(int index) {
        this.index = index;
    }

    public static Direction turnRight(Direction direction) {
        return getByIndex((direction.index + 1) % values().length);
    }

    private static Direction getByIndex(int index) {
        return values()[index];
    }

    public static Direction turnLeft(Direction direction) {
        return getByIndex((direction.index - 1) + values().length);
    }
}
