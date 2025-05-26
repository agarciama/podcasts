package es.upsa.dasi.creadores.domain.repository;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

import java.util.List;
import java.util.Optional;

public interface Repository
{
    List<Creador> getCreadores () throws PodcastsAppException;
    List<Creador> getCreadoresByIds(List<String> ids) throws PodcastsAppException;
    Optional<Creador> getCreadorById (String id) throws PodcastsAppException;
    Creador saveCreador(Creador creador) throws PodcastsAppException;
    void removeCreadorById(String id) throws PodcastsAppException;
}
