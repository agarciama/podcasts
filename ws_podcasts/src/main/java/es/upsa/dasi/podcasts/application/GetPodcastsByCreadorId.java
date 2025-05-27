package es.upsa.dasi.podcasts.application;

import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

import java.util.List;

public interface GetPodcastsByCreadorId
{
    List<Podcast> execute(String id) throws PodcastsAppException;
}
