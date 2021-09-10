package euler;

import org.junit.jupiter.api.Test;

import static euler.Problem1.*;
import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {


    @Test
    void should_return_sum_of_multiple_of_3_or_5_below_10() {
        assertThat(process(10)).isEqualTo(23);
    }

    @Test
    void should_return_sum_of_multiple_of_3_or_5_below_1000() {
        assertThat(process(1000)).isEqualTo(233168);
    }
}