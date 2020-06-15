package experiments.http;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("greet")
public class MyJerseyController {


    @GET
    public String greet() {
        return "Ohayou!";
    }
}
