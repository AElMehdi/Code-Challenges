package hackerrank;

import org.junit.jupiter.api.Test;

import static hackerrank.Solution.arrayManipulation;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {


    @Test
    void should_raise_exception_when_n_is_strictly__lesser_than_3() {
        assertThrows(IllegalArgumentException.class,
                () -> arrayManipulation(2, new int[][]{}));

    }


    @Test
    void should_raise_exception_when_n_is_strictly_greater_than_10_exp_7() {
        assertThrows(IllegalArgumentException.class,
                () -> arrayManipulation((int) Math.pow(10, 7) + 1, new int[][]{}));

    }
}