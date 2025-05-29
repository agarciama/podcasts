package es.upsa.dasi.web.application.podcasts.impl;

import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.web.application.podcasts.FindPodcastByIdUseCase;
import es.upsa.dasi.web.domain.exceptions.CreadorNotFoundRuntimeException;
import es.upsa.dasi.web.infrastructure.rest.PodcastsGatewayRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Optional;

@ApplicationScoped
public class FindPodcastByIdUseCaseImpl implements FindPodcastByIdUseCase
{
    @Inject
    @RestClient
    PodcastsGatewayRestClient restClient;

    @Override
    public Optional<Podcast> execute(String id) {
        try {
            return Optional.of(restClient.findPodcastById(id));

        }catch (CreadorNotFoundRuntimeException creadorNotFoundRuntimeException){
            return Optional.empty();
        }
    }
}
