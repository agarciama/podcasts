package es.upsa.dasi.gateway.adapters.input.rest;

import es.upsa.dasi.gateway.infrastrcuture.rest.restapis.raw.MsCreadoresRawRestClient;
import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.net.URI;

@Path("/creadores")
public class CreadoresResource {

    @Inject
    @RestClient
    MsCreadoresRawRestClient restClientCreadores;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCreador(@QueryParam("ids") @DefaultValue("") String ids)
    {
        return (ids.isEmpty())? restClientCreadores.findAll(): restClientCreadores.findAll(ids);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getCreadorById (@PathParam ("id") String id)
    {
        return restClientCreadores.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCreador (CreadorDto creadorDto, @Context UriInfo uriInfo)
    {
        URI baseUri = uriInfo.getBaseUri();
        String protocol = baseUri.getScheme();
        String host = baseUri.getHost();
        String port = String.valueOf(baseUri.getPort());
        return restClientCreadores.create(creadorDto, host, port, protocol);

    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCreador(@PathParam("id") String id, CreadorDto creadorDto){
        return restClientCreadores.update(id, creadorDto);
    }


    @DELETE
    @Path("/{id}")
    public Response deleteCreadorById(@PathParam("id") String id){
        return restClientCreadores.delete(id);
    }


}
