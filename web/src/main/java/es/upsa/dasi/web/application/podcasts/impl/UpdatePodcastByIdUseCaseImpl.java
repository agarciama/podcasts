package es.upsa.dasi.web.application.podcasts.impl;

import es.upsa.dasi.podcasts.domain.dtos.PodcastDto;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.web.application.podcasts.UpdatePodcastByIdUseCase;
import es.upsa.dasi.web.domain.exceptions.PodcastNotFoundRuntimeException;
import es.upsa.dasi.web.infrastructure.rest.PodcastsGatewayRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class UpdatePodcastByIdUseCaseImpl implements UpdatePodcastByIdUseCase
{
    @Inject
    PodcastsGatewayRestClient restClient;

    @Override
    public Optional<Podcast> execute(String id, PodcastDto podcastDto) {
        try{
            return Optional.ofNullable(restClient.updatePodcastsById(id, podcastDto));
        }catch (PodcastNotFoundRuntimeException podcastNotFoundRuntimeException){
            return Optional.empty();
        }
    }
}
