package es.upsa.dasi.web.adapters.input.rest;


import es.upsa.dasi.podcasts.domain.dtos.PodcastDto;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.web.adapters.input.rest.dtos.Actions;
import es.upsa.dasi.web.adapters.input.rest.dtos.PodcastForm;
import es.upsa.dasi.web.adapters.input.rest.mappers.Mappers;
import es.upsa.dasi.web.application.podcasts.*;
import es.upsa.dasi.web.domain.exceptions.PodcastNotFoundRuntimeException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mvc.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Path("/podcasts")
public class PodcastsController
{
    @Inject
    Models models;

    @Inject
    MvcContext mvc;

    @Inject
    FindPodcastUseCase findPodcastUseCase;

    @Inject
    FindPodcastByIdUseCase findPodcastByIdUseCase;

    @Inject
    UpdatePodcastByIdUseCase updatePodcastByIdUseCase;

    @Inject
    InsertPodcastUseCase insertPodcastUseCase;

    @Inject
    DeletePodcastByIdUseCase deletePodcastByIdUseCase;

    @GET
    @Controller
    @UriRef("findPodcasts")
    @View("/jsps/podcasts.jsp")
    public void findAll() {
        List<Podcast> podcasts = findPodcastUseCase.execute();
        models.put("podcasts", podcasts);
    }

    @GET
    @Path("/{id}")
    @Controller
    @UriRef("findPodcastById")
    public Response findById(@PathParam("id") String id) {
        Optional<Podcast> opt = findPodcastByIdUseCase.execute(id);
        if (opt.isEmpty()) {
            return Response.ok("/jsps/podcastNotFound.jsp").build();
        }
        models.put("podcast", opt.get());
        models.put("action", Actions.VIEW);
        return Response.ok().entity("/jsps/podcast.jsp").build();
    }

    @PUT
    @Path("/{id}")
    @UriRef("updatePodcastById")
    @Controller
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updatePodcastById (@PathParam("id") String id,@BeanParam PodcastForm podcastForm){
        PodcastDto podcastDto = Mappers.toPodcastDto(podcastForm);
        Optional<Podcast> optPodcast = updatePodcastByIdUseCase.execute(id, podcastDto);

        if (optPodcast.isEmpty()) return Response.ok("/jsps/podcastNotFound.jsp").build();

        return Response.seeOther(mvc.uri("findPodcasts")).build();
    }

    @POST
    @Controller
    @UriRef("insertPodcast")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response insertPodcast (@BeanParam PodcastForm podcastForm)
    {
        PodcastDto podcastDto = Mappers.toPodcastDto(podcastForm);
        insertPodcastUseCase.execute(podcastDto);

        return Response.seeOther(mvc.uri("findPodcasts")).build();

    }


    @DELETE
    @Path("/{id}")
    @UriRef("removePodcastById")
    @Controller
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response removePodcastById(@PathParam("id") String id)
    {
        try{
            deletePodcastByIdUseCase.execute(id);
            return Response.seeOther(mvc.uri("findPodcasts")).build();

        }catch (PodcastNotFoundRuntimeException exception)
        {
            return Response.ok("/jsps/podcastNotFound").build();

        }catch (InternalServerErrorException exception)
        {
            models.put("error", exception.getMessage());
            return Response.ok("/jsps/error").build();
        }

    }


}
