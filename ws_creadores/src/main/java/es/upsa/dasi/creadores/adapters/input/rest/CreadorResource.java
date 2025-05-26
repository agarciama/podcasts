package es.upsa.dasi.creadores.adapters.input.rest;

import es.upsa.dasi.creadores.application.GetCreadoresByIdsUseCase;
import es.upsa.dasi.creadores.application.GetCreadoresUseCase;
import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/creadores")
public class CreadorResource
{

    @Inject
    GetCreadoresUseCase getCreadoresUseCase;

    @Inject
    GetCreadoresByIdsUseCase getCreadoresByIdsUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCreadores(@DefaultValue("") @QueryParam("ids") List<String> ids ) throws PodcastsAppException
    {

        List<Creador> creadores = ( ids.isEmpty() )? getCreadoresUseCase.execute() : getCreadoresByIdsUseCase.execute(ids);



        return Response.ok()
                .entity( new GenericEntity<List<Creador>>( creadores ) {})
                .build();
    }




}
