package es.upsa.dasi.web.infrastructure.rest;


import es.upsa.dasi.podcasts.domain.entities.Creador;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:8083")
public interface GatewayRestClient
{
    @GET
    @Path("/creadores")
    @Produces(MediaType.APPLICATION_JSON)
    List<Creador> findCreadores();

}
