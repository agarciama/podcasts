package es.upsa.dasi.podcasts.application;

import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

import java.util.Optional;

public interface GetPodcastsByIdUseCase
{
    Optional<Podcast> execute(String id) throws PodcastsAppException;
}
