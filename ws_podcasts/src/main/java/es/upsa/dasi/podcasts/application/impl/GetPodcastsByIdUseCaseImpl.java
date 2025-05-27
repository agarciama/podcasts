package es.upsa.dasi.podcasts.application.impl;

import es.upsa.dasi.podcasts.application.GetPodcastsByIdUseCase;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.podcasts.domain.repository.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class GetPodcastsByIdUseCaseImpl implements GetPodcastsByIdUseCase
{
    @Inject
    Repository repository;


    @Override
    public Optional<Podcast> execute(String id) throws PodcastsAppException {
        return repository.getPodcastById(id);
    }
}
