package es.upsa.dasi.web.application.podcasts.impl;

import es.upsa.dasi.podcasts.domain.dtos.PodcastDto;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.web.application.podcasts.InsertPodcastUseCase;
import es.upsa.dasi.web.infrastructure.rest.PodcastsGatewayRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class InsertPodcastUseCaseImpl implements InsertPodcastUseCase
{
    @Inject
    @RestClient
    PodcastsGatewayRestClient restClient;

    @Override
    public Podcast execute(PodcastDto podcastDto) {
        return restClient.createPodcast(podcastDto);
    }
}
