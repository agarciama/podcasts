package es.upsa.dasi.creadores.application;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

public interface UpdateCreadorUseCase
{
    Creador execute (Creador creador) throws PodcastsAppException;
}
