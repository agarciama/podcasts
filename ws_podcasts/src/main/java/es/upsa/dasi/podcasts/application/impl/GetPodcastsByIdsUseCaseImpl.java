package es.upsa.dasi.podcasts.application.impl;

import es.upsa.dasi.podcasts.application.GetPodcastsByIdsUseCase;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.podcasts.domain.repository.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GetPodcastsByIdsUseCaseImpl implements GetPodcastsByIdsUseCase
{
    @Inject
    Repository repository;

    @Override
    public List<Podcast> execute(List<String> ids) throws PodcastsAppException {
        return repository.getPodcastsByIds(ids);
    }
}
