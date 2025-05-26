package es.upsa.dasi.creadores.adapters.output.persistence;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

import java.util.List;
import java.util.Optional;

public interface Dao
{
    List<Creador> findCreadores() throws PodcastsAppException;
    List<Creador> findCreadoresByIds(List<String> ids) throws PodcastsAppException;
    Optional<Creador> findCreadorById(String id) throws PodcastsAppException;

    Creador insertCreador(Creador creador) throws PodcastsAppException;
    Optional<Creador> updateCreador(Creador creador) throws PodcastsAppException;
}
