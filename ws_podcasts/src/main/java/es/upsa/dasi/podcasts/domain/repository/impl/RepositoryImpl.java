package es.upsa.dasi.podcasts.domain.repository.impl;

import es.upsa.dasi.podcasts.adapters.output.persistence.Dao;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.podcasts.domain.repository.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class RepositoryImpl implements Repository
{

    @Inject
    Dao dao;

    @Override
    public List<Podcast> getPodcasts() throws PodcastsAppException {
        return dao.findPodcasts();
    }

    @Override
    public List<Podcast> getPodcastsByIds(List<String> ids) throws PodcastsAppException {
        return dao.findPodcastsByIds(ids);
    }

    @Override
    public Optional<Podcast> getPodcastById(String id) throws PodcastsAppException {
        return dao.findPodcastById(id);
    }
}
