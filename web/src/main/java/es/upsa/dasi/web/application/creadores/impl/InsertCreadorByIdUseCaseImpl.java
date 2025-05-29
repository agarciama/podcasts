package es.upsa.dasi.web.application.creadores.impl;

import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.web.application.creadores.InsertCreadorByIdUseCase;
import es.upsa.dasi.web.infrastructure.rest.CreadoresGatewayRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class InsertCreadorByIdUseCaseImpl implements InsertCreadorByIdUseCase
{
    @Inject
    @RestClient
    CreadoresGatewayRestClient restClient;

    @Override
    public Creador execute(CreadorDto creadorDto) {
        return restClient.createCreador(creadorDto);
    }
}
