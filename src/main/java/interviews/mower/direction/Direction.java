package interviews.mower.direction;

import interviews.mower.Coordinate;
import interviews.mower.Lawn;
import interviews.mower.Mower;

public interface Direction {

    void execute(Mower mower, Lawn lawn);

    DirectionLabel getLabel();

    default boolean isOutOfLawn(Lawn lawn, Coordinate coordinate) {
        return coordinate.isGreaterThan(lawn.getTopRightCorner()) ||
                coordinate.isLesserThan(Lawn.getLeftBottomCorner());
    }
}
