package euler;

import org.junit.jupiter.api.Test;

import static euler.Problem2.process;
import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {

    @Test
    void should_sum_up_fibonacci_even_numbers_until_reaching_4_million() {
        assertThat(process()).isEqualTo(4613732);
    }
}
