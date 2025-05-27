package es.upsa.dasi.creadores.adapters.input.rest;

import es.upsa.dasi.creadores.application.*;
import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.CreadorNotFoundException;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.podcasts.domain.mappers.Mappers;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Path("/creadores")
public class CreadorResource
{

    @Inject
    GetCreadoresUseCase getCreadoresUseCase;

    @Inject
    GetCreadoresByIdsUseCase getCreadoresByIdsUseCase;

    @Inject
    GetCreadorByIdUseCase getCreadorByIdUseCase;

    @Inject
    AddCreadorUseCase addCreadorUseCase;

    @Inject
    UpdateCreadorUseCase updateCreadorUseCase;

    @Inject
    RemoveCreadorUseCase removeCreadorUseCase;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCreadores(@DefaultValue("") @QueryParam("ids") List<String> ids ) throws PodcastsAppException
    {

        List<Creador> creadores = ( ids.isEmpty() )? getCreadoresUseCase.execute() : getCreadoresByIdsUseCase.execute(ids);

        return Response.ok()
                .entity( new GenericEntity<List<Creador>>( creadores ) {})
                .build();
    }


    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCreadorById(@PathParam("id") String id) throws PodcastsAppException
    {
        Optional<Creador> optCreador = getCreadorByIdUseCase.execute(id);

        return optCreador.map(creador -> Response.ok()
                        .entity(creador)
                        .build()
                )
                .orElseThrow(CreadorNotFoundException::new);


    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCreador(CreadorDto creadorDto, @Context UriInfo uriInfo) throws PodcastsAppException
    {
        Creador creador = Mappers.toCreador(creadorDto);


        Creador creadorInsertado = addCreadorUseCase.execute(creador);


        return Response.created(  createCreadorURI(uriInfo, creadorInsertado)  )
                .entity( creadorInsertado )
                .build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCreador(@PathParam("id") String id, CreadorDto creadorDto) throws PodcastsAppException
    {
        Creador creador = Mappers.toCreador(creadorDto)
                                 .withId(id);


        Creador creadorUpdated = updateCreadorUseCase.execute(creador);

        return Response.ok()
                .entity(creadorUpdated)
                .build();
    }


    @Path("/{id}")
    @DELETE
    public Response deleteCreadorById(@PathParam("id") String id) throws PodcastsAppException
    {
        removeCreadorUseCase.execute(id);

        return Response.noContent()
                .build();
    }


    private URI createCreadorURI(UriInfo uriInfo, Creador creador)
    {
        return uriInfo.getBaseUriBuilder()
                .path("/creadores/{id}")
                .resolveTemplate("id", creador.getId())
                .build();

    }









}
