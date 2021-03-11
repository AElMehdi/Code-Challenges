package interviews.mower;

import interviews.mower.Coordinate;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinateTest {

    @Test
    void should_return_false_when_caller_x_value_is_greater_than_or_equal_to_the_one_compared_to() {
        Coordinate coordinate = new Coordinate(4, 8);
        boolean result = coordinate.isGreaterThan(new Coordinate(4, 8));
        assertThat(result).isFalse();
    }

    @Test
    void should_return_true_when_caller_x_value_is_greater_than_the_one_compared_to() {
        Coordinate coordinate = new Coordinate(4, 8);
        boolean result = coordinate.isGreaterThan(new Coordinate(3, 8));
        assertThat(result).isTrue();
    }

    @Test
    void should_return_false_when_caller_y_value_is_greater_than_or_equal_to_the_one_compared_to() {
        Coordinate coordinate = new Coordinate(2, 8);
        boolean result = coordinate.isGreaterThan(new Coordinate(4, 8));
        assertThat(result).isFalse();
    }

    @Test
    void should_return_true_when_caller_y_value_is_greater_than_the_one_compared_to() {
        Coordinate coordinate = new Coordinate(4, 8);
        boolean result = coordinate.isGreaterThan(new Coordinate(4, 4));
        assertThat(result).isTrue();
    }

    @Test
    void should_return_false_when_caller_x_value_is_lesser_than_or_equal_to_the_one_compared_to() {
        Coordinate coordinate = new Coordinate(0, 4);
        boolean result = coordinate.isLesserThan(new Coordinate(0, 0));
        assertThat(result).isFalse();
    }

    @Test
    void should_return_true_when_caller_x_value_is_lesser_than_the_one_compared_to() {
        Coordinate coordinate = new Coordinate(-1, 4);
        boolean result = coordinate.isLesserThan(new Coordinate(0, 0));
        assertThat(result).isTrue();
    }

    @Test
    void should_return_false_when_caller_y_value_is_lesser_than_or_equal_to_the_one_compared_to() {
        Coordinate coordinate = new Coordinate(4, 0);
        boolean result = coordinate.isLesserThan(new Coordinate(2, 0));
        assertThat(result).isFalse();
    }

    @Test
    void should_return_true_when_caller_y_value_is_lesser_than_the_one_compared_to() {
        Coordinate coordinate = new Coordinate(4, -1);
        boolean result = coordinate.isLesserThan(new Coordinate(2, 0));
        assertThat(result).isTrue();
    }
}