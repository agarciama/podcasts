package es.upsa.dasi.web.application.creadores.application.creadores.impl;

import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.web.application.creadores.application.creadores.UpdateCreadorByIdUseCase;
import es.upsa.dasi.web.domain.exceptions.CreadorNotFoundRuntimeException;
import es.upsa.dasi.web.infrastructure.rest.CreadoresGatewayRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;

import java.util.Optional;

@ApplicationScoped
public class UpdateCreadorByIdUseCaseImpl implements UpdateCreadorByIdUseCase
{
    @Inject
    CreadoresGatewayRestClient restClient;

    @Override
    public Optional<Creador> execute(String id, CreadorDto creadorDto) {
        try{
            return Optional.ofNullable(restClient.updateCreadoresById(id, creadorDto));
        }catch (CreadorNotFoundRuntimeException creadorNotFoundRuntimeException){
            return Optional.empty();
        }

    }
}
