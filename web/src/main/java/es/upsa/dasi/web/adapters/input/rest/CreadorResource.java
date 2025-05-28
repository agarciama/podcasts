package es.upsa.dasi.web.adapters.input.rest;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.web.application.FindCreadoresUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@ApplicationScoped
@Path("/creadores")
public class CreadorResource
{
    @Inject
    FindCreadoresUseCase findCreadoresUseCase;

    @Inject
    Models models;

    @GET
    @Controller
    @View("/jsps/creadores.jsp")
    public void findAll() throws PodcastsAppException
    {
        List<Creador> creadores = findCreadoresUseCase.execute();
        models.put("creadores", creadores);
    }
}
