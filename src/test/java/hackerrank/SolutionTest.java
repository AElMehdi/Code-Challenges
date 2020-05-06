package hackerrank;

import org.junit.jupiter.api.Test;

import static hackerrank.Solution.arrayManipulation;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {


    @Test
    void should_raise_exception_when_n_is_lesser_than_3() {
        assertThrows(IllegalArgumentException.class,
                () -> arrayManipulation(1, new int[][]{}));

    }
}