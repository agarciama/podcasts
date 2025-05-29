package es.upsa.dasi.web.application.podcasts.impl;

import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.web.application.podcasts.FindPodcastUseCase;
import es.upsa.dasi.web.infrastructure.rest.PodcastsGatewayRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class FindPodcastUseCaseImpl implements FindPodcastUseCase
{
    @Inject
    @RestClient
    PodcastsGatewayRestClient restClient;

    @Override
    public List<Podcast> execute() {
        return restClient.findPodcasts();
    }
}
