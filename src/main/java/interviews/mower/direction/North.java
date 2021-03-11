package interviews.mower.direction;

import interviews.mower.Coordinate;
import interviews.mower.Lawn;
import interviews.mower.Mower;

import java.util.Objects;

public class North implements Direction {

    private static final DirectionLabel LABEL = DirectionLabel.N;

    @Override
    public void execute(Mower mower, Lawn lawn) {
        Coordinate actualCoordinate = mower.getCoordinate();
        Coordinate nextCoordinate = new Coordinate(actualCoordinate.getX(), actualCoordinate.getY() + 1);

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
        return "North{" +
                "label='" + LABEL + '\'' +
                '}';
    }
}
