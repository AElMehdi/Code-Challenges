package interviews.mower.direction;

public enum DirectionLabel {
    N,
    E,
    S,
    W;


    public static final int LENGTH = values().length;

    public static Direction turnRight(Direction direction) {
        int index = toDirectionLabel(direction).ordinal() + 1;
        return getByIndex(index % LENGTH);
    }

    public static Direction turnLeft(Direction direction) {
        DirectionLabel directionLabel = toDirectionLabel(direction);
        int index = directionLabel.ordinal() - 1;
        return getByIndex(isNorth(directionLabel) ?
                convertNegative(index) :
                index);
    }

    private static int convertNegative(int index) {
        return index + LENGTH;
    }

    private static Direction getByIndex(int index) {
        return toDirection(values()[index].name());
    }

    private static boolean isNorth(DirectionLabel direction) {
        return direction.ordinal() == 0;
    }


    public static Direction toDirection(String directionLabel) {
        switch (valueOf(directionLabel)) {
            case N:
                return new North();
            case E:
                return new East();
            case S:
                return new South();
            case W:
                return new West();
            default:
                throw new IllegalStateException("Unexpected value: " + valueOf(directionLabel));
        }
    }

    public static DirectionLabel toDirectionLabel(Direction direction) {
        if (direction instanceof North) {
            return N;
        } else if (direction instanceof East) {
            return E;
        } else if (direction instanceof South) {
            return S;
        } else if (direction instanceof West) {
            return W;
        }
        throw new IllegalStateException("Unexpected value: " + direction.getClass().getSimpleName());
    }
}
