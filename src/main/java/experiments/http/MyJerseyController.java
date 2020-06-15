package experiments.http;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("greet")
public class MyJerseyController {


    @GET
    public String greet() {
        return "Ohayou!";
    }

    public Response redirect() {
        throw new UnsupportedOperationException();
    }
}
