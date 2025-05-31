package es.upsa.dasi.web.adapters.input.rest.forms;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.web.adapters.input.rest.dtos.Actions;
import es.upsa.dasi.web.application.creadores.FindCreadorByIdUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.UriRef;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@ApplicationScoped
@Path("/form/creadores")
public class FormsCreadoresResource
{
    @Inject
    FindCreadorByIdUseCase findCreadorByIdUseCase;

    @Inject
    Models models;

    @GET
    @Path("/insert")
    @Controller
    @UriRef("formInsertCreador")
    public Response formInsertCreador() {
        models.put("creador", new Creador());
        models.put("action", Actions.INSERT);
        return Response.ok("/jsps/creador.jsp").build();
    }

    @GET
    @Path("/update/{id}")
    @Controller
    @UriRef("formUpdateCreadorByid")
    public Response formUpdateCreadorByid (@PathParam("id") String id)
    {
        Optional<Creador> optionalCreador = findCreadorByIdUseCase.execute(id);
        if (optionalCreador.isEmpty()) return Response.ok("/jsps/creadorNotFound.jsp").build();

        models.put("creador", optionalCreador.get());
        models.put("action", Actions.UPDATE);
        return Response.ok("/jsps/creador.jsp").build();
    }

    @GET
    @Path("/delete/{id}")
    @Controller
    @UriRef("formDeleteCreadorByid")
    public Response formDeleteCreadorByid(@PathParam("id") String id) {
        Optional<Creador> optional = findCreadorByIdUseCase.execute(id);
        if (optional.isEmpty()) {
            return Response.ok("/jsps/creadorNotFound.jsp").build();
        }
        models.put("creador", optional.get());
        models.put("action", Actions.DELETE);
        return Response.ok("/jsps/creador.jsp").build();
    }
}
