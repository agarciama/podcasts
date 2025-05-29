package es.upsa.dasi.web.adapters.input.rest;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.web.application.FindCreadorByIdUseCase;
import es.upsa.dasi.web.application.FindCreadoresUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.UriRef;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Path("/creadores")
public class CreadorResource
{
    @Inject
    FindCreadoresUseCase findCreadoresUseCase;

    @Inject
    FindCreadorByIdUseCase findCreadorByIdUseCase;

    @Inject
    Models models;

    @GET
    @Controller
    @UriRef("findCreadores")
    @View("/jsps/creadores.jsp")
    public void findAll()
    {
        List<Creador> creadores = findCreadoresUseCase.execute();
        models.put("creadores", creadores);
    }


    @GET
    @Controller
    @UriRef("findCreadoresById")
    @Path("/creadores/{id}")
    public Response findById (@PathParam("id") String id)
    {

        String target;

        Optional<Creador> optCreador = findCreadorByIdUseCase.execute(id);

        if (optCreador.isPresent())
        {
            models.put("creador", optCreador.get());
            target = "/jsps/creador.jsp";
        }else{
            target = "/jsps/creadorNotFound.jsp";
        }

        return Response.ok()
                       .entity(target)
                       .build();

    }

}
