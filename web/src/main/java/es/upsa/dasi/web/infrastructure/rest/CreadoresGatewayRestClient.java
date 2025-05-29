package es.upsa.dasi.web.infrastructure.rest;


import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.web.infrastructure.rest.providers.CreadoresResponseExceptionMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:8083")
@RegisterProvider(CreadoresResponseExceptionMapper.class)
public interface CreadoresGatewayRestClient
{
    @GET
    @Path("/creadores")
    @Produces(MediaType.APPLICATION_JSON)
    List<Creador> findCreadores();

    @GET
    @Path("/creadores/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Creador findCreadoresById(@PathParam("id") String id);

    @PUT
    @Path("/creadores/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Creador updateCreadoresById(@PathParam("id") String id, CreadorDto creadorDto);

    @POST @Path("/creadores")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Creador createCreador(CreadorDto creadorDto);

    @DELETE
    @Path("/creadores/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response deleteCreadorById(@PathParam("id") String id);

}
