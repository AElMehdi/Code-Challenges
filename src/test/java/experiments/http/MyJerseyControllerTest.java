package experiments.http;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

class MyJerseyControllerTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(MyJerseyController.class);
    }

    @BeforeEach
    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @AfterEach
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }


    @Test
    void should_greet_after_we_meet() {
        String greet = target("greet").request().get(String.class);
        assertThat(greet).isEqualTo("Ohayou!");
    }

    @Test
    void should_redirect_and_set_the_right_redirection_status() {
        Response redirectResponse = target().request().get(Response.class);
        assertThat(redirectResponse.getStatus()).isEqualTo(302);
    }
}