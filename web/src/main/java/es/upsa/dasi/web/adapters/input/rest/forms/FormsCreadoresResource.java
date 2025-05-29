package es.upsa.dasi.web.adapters.input.rest.forms;

import jakarta.mvc.Controller;
import jakarta.mvc.UriRef;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/form")
public class FormsResource
{
    @Path("/update/creador/{id}")
    @Controller
    @UriRef("formUpdateCreadorByid")
    public Response formUpdateCreadorByid (@PathParam("id") String id){
        
    }

}
