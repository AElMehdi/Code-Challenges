package interviews;

public enum Direction {
    N,
    E,
    S,
    W;


    public static final int LENGTH = values().length;

    public static Direction turnRight(Direction direction) {
        int index = direction.ordinal() + 1;
        return getByIndex(index % LENGTH);
    }

    public static Direction turnLeft(Direction direction) {
        int index = direction.ordinal() - 1;
        return getByIndex(isNorth(direction) ?
                convertNegative(index) :
                index);
    }

    private static int convertNegative(int index) {
        return index + LENGTH;
    }

    private static Direction getByIndex(int index) {
        return values()[index];
    }

    private static boolean isNorth(Direction direction) {
        return direction.ordinal() == 0;
    }
}
