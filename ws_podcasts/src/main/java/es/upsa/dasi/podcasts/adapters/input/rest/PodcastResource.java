package es.upsa.dasi.podcasts.adapters.input.rest;

import es.upsa.dasi.podcasts.application.GetPodcastsByCreadorId;
import es.upsa.dasi.podcasts.application.GetPodcastsByIdUseCase;
import es.upsa.dasi.podcasts.application.GetPodcastsByIdsUseCase;
import es.upsa.dasi.podcasts.application.GetPodcastsUseCase;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsNotFoundException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/podcasts")
public class PodcastResource
{
    @Inject
    GetPodcastsUseCase getPodcastsUseCase;

    @Inject
    GetPodcastsByIdsUseCase getPodcastsByIdsUseCase;

    @Inject
    GetPodcastsByIdUseCase getPodcastsByIdUseCase;

    @Inject
    GetPodcastsByCreadorId getPodcastsByCreadorId;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPodcasts(@DefaultValue("") @QueryParam("ids") List<String> ids ) throws PodcastsAppException
    {

        List<Podcast> podcasts = ( ids.isEmpty() )? getPodcastsUseCase.execute() : getPodcastsByIdsUseCase.execute(ids);

        return Response.ok()
                .entity( new GenericEntity<List<Podcast>>(podcasts) {})
                .build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPodcastsById(@PathParam("id") String id) throws PodcastsAppException
    {
        Optional<Podcast> optPodcast = getPodcastsByIdUseCase.execute(id);

        return optPodcast.map(podcast -> Response.ok()
                                                            .entity(podcast)
                                                            .build()
                )
                .orElseThrow(PodcastsNotFoundException::new);


    }

    @Path("creador/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPodcastsByCreadorId(@PathParam("id") String id) throws PodcastsAppException
    {

        List<Podcast> podcasts = getPodcastsByCreadorId.execute(id);

        return Response.ok()
                       .entity(new GenericEntity<List<Podcast>>(podcasts){})
                       .build();


    }


}
