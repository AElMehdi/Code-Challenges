package interviews.mower.direction;


import interviews.mower.Coordinate;
import interviews.mower.Lawn;
import interviews.mower.Mower;

import java.util.Objects;

import static interviews.mower.direction.DirectionLabel.S;

public class South implements Direction {

    private static final DirectionLabel LABEL = S;

    @Override
    public void execute(Mower mower, Lawn lawn) {
        Coordinate actualCoordinate = mower.getCoordinate();
        Coordinate nextCoordinate = new Coordinate(actualCoordinate.getX(), actualCoordinate.getY() - 1);

        if (isOutOfLawn(lawn, nextCoordinate)) {
            return;
        }

        mower.setCoordinate(nextCoordinate);
    }

    @Override
    public DirectionLabel getLabel() {
        return LABEL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(LABEL);
    }

    @Override
    public String toString() {
        return "South{" +
                "label='" + LABEL + '\'' +
                '}';
    }
}
