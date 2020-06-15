package experiments.http;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyJerseyControllerTest {

    private MyJerseyController myJerseyController;

    @Test
    void should_greet_after_we_meet() {
        assertThat(myJerseyController.greet());
    }
}