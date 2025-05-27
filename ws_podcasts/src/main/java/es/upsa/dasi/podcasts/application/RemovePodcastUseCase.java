package es.upsa.dasi.podcasts.application;

import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

public interface RemovePodcastUseCase
{
    void execute (String id) throws PodcastsAppException;
}
