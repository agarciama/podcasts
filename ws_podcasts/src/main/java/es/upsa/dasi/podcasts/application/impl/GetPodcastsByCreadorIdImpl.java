package es.upsa.dasi.podcasts.application.impl;

import es.upsa.dasi.podcasts.application.GetPodcastsByCreadorId;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.podcasts.domain.repository.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GetPodcastsByCreadorIdImpl implements GetPodcastsByCreadorId
{
    @Inject
    Repository repository;

    @Override
    public List<Podcast> execute(String id) throws PodcastsAppException {
        return repository.getPodcastsByCreadorId(id);
    }
}
