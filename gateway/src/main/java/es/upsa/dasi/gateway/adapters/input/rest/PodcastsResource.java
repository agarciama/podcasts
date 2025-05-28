package es.upsa.dasi.gateway.adapters.input.rest;

import es.upsa.dasi.gateway.infrastrcuture.rest.restapis.raw.MsPodcastsRawRestClient;
import es.upsa.dasi.podcasts.domain.dtos.PodcastDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.net.URI;

@Path("/podcasts")
public class PodcastsResource
{
    @Inject
    @RestClient
    MsPodcastsRawRestClient restClientPodcasts;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPeliculas(@QueryParam("ids") @DefaultValue("") String ids)
    {
        return (ids.isEmpty())? restClientPodcasts.findAll(): restClientPodcasts.findAll(ids);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findPeliculaById (@PathParam ("id") String id)
    {
        return restClientPodcasts.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create (PodcastDto podcastDto, @Context UriInfo uriInfo)
    {
        URI baseUri = uriInfo.getBaseUri();
        String protocol = baseUri.getScheme();
        String host = baseUri.getHost();
        String port = String.valueOf(baseUri.getPort());
        return restClientPodcasts.create(podcastDto, host, port, protocol);

    }


    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePelicula(@PathParam("id") String id, PodcastDto podcastDto){
        return restClientPodcasts.update(id, podcastDto);
    }


    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id){
        return restClientPodcasts.delete(id);
    }

}
