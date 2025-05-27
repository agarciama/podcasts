package es.upsa.dasi.podcasts.application.impl;

import es.upsa.dasi.podcasts.application.AddPodcastUseCase;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.podcasts.domain.repository.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AddPodcastUseCaseImpl implements AddPodcastUseCase
{
    @Inject
    Repository repository;

    @Override
    public Podcast execute(Podcast podcast) throws PodcastsAppException {
        return repository.savePodcast(podcast);
    }
}
