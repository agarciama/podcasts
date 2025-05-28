package es.upsa.dasi.gateway.infrastrcuture.rest.restapis.raw;

import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import es.upsa.dasi.podcasts.domain.dtos.PodcastDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8082")
@Path("/podcasts")
public interface MsPodcastsRawRestClient
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response findAll();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response findAll(@QueryParam("ids") String ids);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response findById(@PathParam("id") String id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response create(PodcastDto podcastDto, @HeaderParam("X-Forwarded-Host") String host,
                                           @HeaderParam("X-Forwarded-Port") String port,
                                           @HeaderParam("X-Forwarded-Proto")String proto);

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response update(@PathParam("id") String id, PodcastDto podcastDto);

    @DELETE
    @Path("/{id}")
    Response delete(@PathParam("id") String id);
}
