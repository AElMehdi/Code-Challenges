package interviews;

public class Lawn {
    private final Coordinate topRightCorner;
    private static final Coordinate leftBottomCorner = new Coordinate(0, 0);

    public Lawn(Coordinate topRightCorner) {
        this.topRightCorner = topRightCorner;
    }

    public Coordinate getTopRightCorner() {
        return topRightCorner;
    }

    public static Coordinate getLeftBottomCorner() {
        return leftBottomCorner;
    }
}
