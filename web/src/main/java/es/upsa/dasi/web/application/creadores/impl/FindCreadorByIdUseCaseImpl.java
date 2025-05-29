package es.upsa.dasi.web.application.creadores.impl;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.web.application.creadores.FindCreadorByIdUseCase;
import es.upsa.dasi.web.domain.exceptions.CreadorNotFoundRuntimeException;
import es.upsa.dasi.web.infrastructure.rest.CreadoresGatewayRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class FindCreadorByIdUseCaseImpl implements FindCreadorByIdUseCase
{

    @Inject
    CreadoresGatewayRestClient restClient;

    @Override
    public Optional<Creador> execute(String id)
    {
        try {
            return Optional.of(restClient.findCreadoresById(id));

        }catch (CreadorNotFoundRuntimeException creadorNotFoundRuntimeException){
            return Optional.empty();
        }
    }
}
