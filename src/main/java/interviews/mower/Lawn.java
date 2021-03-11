package interviews.mower;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lawn lawn = (Lawn) o;

        return Objects.equals(topRightCorner, lawn.topRightCorner);
    }

    @Override
    public int hashCode() {
        return topRightCorner != null ? topRightCorner.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Lawn{" +
                "topRightCorner=" + topRightCorner +
                '}';
    }
}
