package es.upsa.dasi.podcasts.application;

import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

public interface UpdatePodcastUseCase
{
    Podcast execute(Podcast podcast) throws PodcastsAppException;
}
