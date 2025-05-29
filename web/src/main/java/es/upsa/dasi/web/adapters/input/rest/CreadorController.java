package es.upsa.dasi.web.adapters.input.rest;

import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import es.upsa.dasi.podcasts.domain.entities.Creador;

import es.upsa.dasi.web.adapters.input.rest.dtos.Actions;
import es.upsa.dasi.web.adapters.input.rest.dtos.CreadorForm;
import es.upsa.dasi.web.adapters.input.rest.mappers.Mappers;
import es.upsa.dasi.web.application.creadores.application.creadores.*;
import es.upsa.dasi.web.domain.exceptions.CreadorNotFoundRuntimeException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mvc.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Path("/creadores")
public class CreadorController
{
    @Inject
    FindCreadoresUseCase findCreadoresUseCase;

    @Inject
    FindCreadorByIdUseCase findCreadorByIdUseCase;

    @Inject
    UpdateCreadorByIdUseCase updateCreadorByIdUseCase;

    @Inject
    InsertCreadorByIdUseCase insertCreadorByIdUseCase;

    @Inject
    DeleteCreadorByIdUseCase deleteCreadorByIdUseCase;

    @Inject
    Models models;

    @Inject
    MvcContext mvc;

    @GET
    @Controller
    @UriRef("findCreadores")
    @View("/jsps/creadores.jsp")
    public void findAll()
    {
        List<Creador> creadores = findCreadoresUseCase.execute();
        models.put("creadores", creadores);
    }


    @GET
    @Controller
    @UriRef("findCreadoresById")
    @Path("/{id}")
    public Response findById (@PathParam("id") String id)
    {

        String target;

        Optional<Creador> optCreador = findCreadorByIdUseCase.execute(id);

        if(optCreador.isEmpty()) return Response.ok("/jsps/creadorNotFound.jsp").build();

        models.put("creador", optCreador.get());
        models.put("action", Actions.VIEW);

        return Response.ok()
                       .entity("/jsps/creador.jsp")
                       .build();

    }


    @POST
    @UriRef("insertCreadorById")
    @Controller
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response insertCreadorById (@BeanParam CreadorForm creadorForm){
        CreadorDto dto = Mappers.toCreadorDto(creadorForm);
        insertCreadorByIdUseCase.execute(dto);

        return Response.seeOther(mvc.uri("findCreadores")).build();
    }


    @PUT
    @Path("/{id}")
    @UriRef("updateCreadorById")
    @Controller
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateCreadorById (@PathParam("id") String id,@BeanParam CreadorForm creadorForm)
    {

        CreadorDto creadorDto = Mappers.toCreadorDto(creadorForm);
        Optional<Creador> optCreador = updateCreadorByIdUseCase.execute(id, creadorDto);

        if (optCreador.isEmpty()) return Response.ok("/jsps/creadorNotFound.jsp").build();

        return Response.seeOther(mvc.uri("findCreadores")).build();

    }

    @DELETE
    @Path("/{id}")
    @UriRef("removeCreadorById")
    @Controller
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response removeCreadorById (@PathParam("id") String id){
        try{
        deleteCreadorByIdUseCase.execute(id);
        return Response.seeOther(mvc.uri("findCreadores")).build();
        }catch (CreadorNotFoundRuntimeException exception){
            return Response.ok("/jsps/creadorNotFound").build();
        } catch (InternalServerErrorException exception) {
            models.put("error", exception.getMessage());
            return Response.ok("/jsps/error").build();
        }
    }







}
