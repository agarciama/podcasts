package es.upsa.dasi.creadores.application;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

import java.util.Optional;

public interface GetCreadorByIdUseCase
{
    Optional<Creador> execute (String id) throws PodcastsAppException;
}
