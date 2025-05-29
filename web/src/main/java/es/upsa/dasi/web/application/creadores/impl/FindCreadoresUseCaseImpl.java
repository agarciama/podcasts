package es.upsa.dasi.web.application.creadores.impl;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.web.application.creadores.FindCreadoresUseCase;
import es.upsa.dasi.web.infrastructure.rest.CreadoresGatewayRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class FindCreadoresUseCaseImpl implements FindCreadoresUseCase
{

    @Inject
    @RestClient
    CreadoresGatewayRestClient restClient;

    @Override
    public List<Creador> execute()
    {
        return restClient.findCreadores();
    }
}
