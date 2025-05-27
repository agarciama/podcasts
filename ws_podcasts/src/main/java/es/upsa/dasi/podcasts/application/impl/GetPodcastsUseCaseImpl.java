package es.upsa.dasi.podcasts.application.impl;

import es.upsa.dasi.podcasts.application.GetPodcastsUseCase;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.podcasts.domain.repository.impl.RepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GetPodcastsUseCaseImpl implements GetPodcastsUseCase
{
    @Inject
    RepositoryImpl repository;

    @Override
    public List<Podcast> execute() throws PodcastsAppException {
        return repository.getPodcasts();
    }
}
