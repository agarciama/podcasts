package es.upsa.dasi.web.infrastructure.rest;


import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;
import java.util.Optional;

@RegisterRestClient(baseUri = "http://localhost:8083")
@RegisterProvider()
public interface GatewayRestClient
{
    @GET
    @Path("/creadores")
    @Produces(MediaType.APPLICATION_JSON)
    List<Creador> findCreadores() throws PodcastsAppException;

    @GET
    @Path("/creadores/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Optional<Creador> findCreadoresById(@PathParam("id") String id) throws PodcastsAppException;

}
