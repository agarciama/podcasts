package es.upsa.dasi.web.application.impl;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.web.application.FindCreadoresUseCase;
import es.upsa.dasi.web.infrastructure.rest.GatewayRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class FindCreadoresUseCaseImpl implements FindCreadoresUseCase
{

    @Inject
    @RestClient
    GatewayRestClient restClient;

    @Override
    public List<Creador> execute() throws PodcastsAppException
    {
        return restClient.findCreadores();
    }
}
