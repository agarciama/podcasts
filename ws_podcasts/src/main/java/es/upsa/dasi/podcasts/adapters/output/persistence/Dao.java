package es.upsa.dasi.podcasts.adapters.output.persistence;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

import java.util.List;
import java.util.Optional;

public interface Dao
{
    List<Podcast> findPodcasts() throws PodcastsAppException;
    List<Podcast> findPodcastsByIds(List<String> ids) throws PodcastsAppException;
    Optional<Podcast> findPodcastById(String id) throws PodcastsAppException;
}
