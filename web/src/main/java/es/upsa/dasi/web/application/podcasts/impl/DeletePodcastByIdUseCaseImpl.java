package es.upsa.dasi.web.application.podcasts.impl;

import es.upsa.dasi.web.application.podcasts.DeletePodcastByIdUseCase;
import es.upsa.dasi.web.infrastructure.rest.PodcastsGatewayRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class DeletePodcastByIdUseCaseImpl implements DeletePodcastByIdUseCase
{
    @Inject
    @RestClient
    PodcastsGatewayRestClient restClient;

    @Override
    public void execute(String id)
    {
        restClient.deletePodcastById(id);
    }
}
