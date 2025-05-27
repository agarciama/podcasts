package es.upsa.dasi.podcasts.domain.repository;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

import java.util.List;
import java.util.Optional;

public interface Repository
{
    List<Podcast> getPodcasts () throws PodcastsAppException;
    List<Podcast> getPodcastsByIds(List<String> ids) throws PodcastsAppException;
    Optional<Podcast> getPodcastById(String id) throws PodcastsAppException;
    List<Podcast> getPodcastsByCreadorId(String id) throws PodcastsAppException;
    Podcast savePodcast(Podcast podcast) throws PodcastsAppException;
    void deletePodcast(String id) throws PodcastsAppException;
}
