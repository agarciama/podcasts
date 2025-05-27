package es.upsa.dasi.podcasts.application.impl;

import es.upsa.dasi.podcasts.application.RemovePodcastUseCase;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.podcasts.domain.repository.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RemovePodcastUseCaseImpl implements RemovePodcastUseCase
{
    @Inject
    Repository repository;

    @Override
    public void execute(String id) throws PodcastsAppException
    {
        repository.deletePodcast(id);

    }
}
