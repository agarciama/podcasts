package es.upsa.dasi.creadores.application;

import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

public interface RemoveCreadorUseCase
{
    void execute(String id) throws PodcastsAppException;
}
