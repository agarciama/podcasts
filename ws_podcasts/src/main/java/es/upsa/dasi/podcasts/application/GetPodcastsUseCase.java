package es.upsa.dasi.podcasts.application;

import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

import java.util.List;

public interface GetPodcastsUseCase
{
    List<Podcast> execute () throws PodcastsAppException;
}
