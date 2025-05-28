package es.upsa.dasi.gateway.infrastrcuture.rest.restapis.raw;


import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8081")
@Path("/creadores")
public interface MsCreadoresRawRestClient
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
    Response create(CreadorDto creadorDto, @HeaderParam("X-Forwarded-Host") String host,
                                           @HeaderParam("X-Forwarded-Port") String port,
                                           @HeaderParam("X-Forwarded-Proto")String proto);

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response update(@PathParam("id") String id, CreadorDto creadorDto);

    @DELETE
    @Path("/{id}")
    Response delete(@PathParam("id") String id);
}
