package es.upsa.dasi.web.infrastructure.rest;

import es.upsa.dasi.podcasts.domain.dtos.PodcastDto;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.web.infrastructure.rest.providers.PodcastsResponseExceptionMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:8083")
@RegisterProvider(PodcastsResponseExceptionMapper.class)
public interface PodcastsGatewayRestClient
{

    @GET
    @Path("/podcasts")
    @Produces(MediaType.APPLICATION_JSON)
    List<Podcast> findPodcasts();

    @GET
    @Path("/podcasts/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Podcast findPodcastById(@PathParam("id") String id);

    @PUT
    @Path("/podcasts/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Podcast updatePodcastsById(@PathParam("id") String id, PodcastDto podcastDto);

    @POST
    @Path("/podcasts")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Podcast createPodcast(PodcastDto podcastDto);

    @DELETE
    @Path("/podcasts/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response deletePodcastById(@PathParam("id") String id);
}
