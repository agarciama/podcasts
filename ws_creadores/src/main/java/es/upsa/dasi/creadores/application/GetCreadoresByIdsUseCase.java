package es.upsa.dasi.creadores.application;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

import java.util.List;

public interface GetCreadoresByIdsUseCase
{
    List<Creador> execute(List<String> ids) throws PodcastsAppException;
}
