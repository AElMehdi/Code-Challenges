package hackerrank;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static hackerrank.ArrayManipulation.parse;
import static org.assertj.core.api.Assertions.*;

class ArrayManipulationTest {


    @Test
    void should_parse_array_size_and_queries() throws IOException {
        ArrayManipulation.ParsedProperties expected = new ArrayManipulation
                .ParsedProperties(10, 100);
        int[] baseArray = {0, 0, 0, 0, 0};

        Arrays.fill(baseArray, 1, 3, 7);


        assertThat(parse("/hackerrank/array_manipulation_input.txt"))
                .isEqualTo(expected);
    }
}