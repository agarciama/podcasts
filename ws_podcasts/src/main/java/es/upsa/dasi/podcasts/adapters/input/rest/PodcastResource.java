package es.upsa.dasi.podcasts.adapters.input.rest;

import es.upsa.dasi.podcasts.application.*;
import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import es.upsa.dasi.podcasts.domain.dtos.PodcastDto;
import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsNotFoundException;
import es.upsa.dasi.podcasts.domain.mappers.Mappers;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;
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

    @Inject
    AddPodcastUseCase addPodcastUseCase;

    @Inject
    UpdatePodcastUseCase updatePodcastUseCase;

    @Inject
    RemovePodcastUseCase removePodcastUseCase;


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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPodcast (PodcastDto podcastDto, @Context UriInfo uriInfo) throws PodcastsAppException
    {
        System.out.println("»»» fechaInicio en DTO = " + podcastDto.getFechaInicio());
        Podcast podcast = Mappers.toPodcast(podcastDto);


        Podcast podcastInsertado = addPodcastUseCase.execute(podcast);


        return Response.created(  createCreadorURI(uriInfo, podcastInsertado)  )
                .entity( podcastInsertado )
                .build();
    }


    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePodcast(@PathParam("id") String id, PodcastDto podcastDto) throws PodcastsAppException
    {
        Podcast podcast = Mappers.toPodcast(podcastDto)
                .withId(id);


        Podcast podcastUpdated = updatePodcastUseCase.execute(podcast);

        return Response.ok()
                .entity(podcastUpdated)
                .build();
    }


    @Path("/{id}")
    @DELETE
    public Response deletePodcastById(@PathParam("id") String id) throws PodcastsAppException
    {
        removePodcastUseCase.execute(id);

        return Response.noContent()
                .build();
    }



    private URI createCreadorURI(UriInfo uriInfo, Podcast podcast)
    {
        return uriInfo.getBaseUriBuilder()
                .path("/podcasts/{id}")
                .resolveTemplate("id", podcast.getId())
                .build();

    }




}
