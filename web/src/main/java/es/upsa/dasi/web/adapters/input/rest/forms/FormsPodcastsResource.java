package es.upsa.dasi.web.adapters.input.rest.forms;


import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.web.adapters.input.rest.dtos.Actions;
import es.upsa.dasi.web.application.podcasts.FindPodcastByIdUseCase;
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
@Path("/form/podcasts")
public class FormsPodcastsResource
{
    @Inject
    FindPodcastByIdUseCase findPodcastByIdUseCase;

    @Inject
    Models models;

    @GET
    @Path("/update/{id}")
    @Controller
    @UriRef("formUpdatePodcastByid")
    public Response formUpdatePodcastByid (@PathParam("id") String id){

        Optional<Podcast> optPodcast = findPodcastByIdUseCase.execute(id);

        if (optPodcast.isEmpty()) return Response.ok("/jsps/podcastNotFound.jsp").build();

        models.put("podcast", optPodcast.get());
        models.put("action", Actions.UPDATE);
        return Response.ok("/jsps/podcast.jsp").build();

    }

    @GET
    @Path("/insert")
    @Controller
    @UriRef("formInsertPodcast")
    public Response formInsertPodcast() {

        models.put("podcast", new Podcast());
        models.put("action", Actions.INSERT);
        return Response.ok("/jsps/podcast.jsp").build();
    }

    @GET
    @Path("/delete/{id}")
    @Controller
    @UriRef("formDeletePodcastByid")
    public Response formDeletePodcastByid(@PathParam("id") String id)
    {
        Optional<Podcast> optional = findPodcastByIdUseCase.execute(id);

        if (optional.isEmpty()) {
            return Response.ok("/jsps/podcastNotFound.jsp").build();
        }

        models.put("podcast", optional.get());
        models.put("action", Actions.DELETE);
        return Response.ok("/jsps/podcast.jsp").build();
    }
}
