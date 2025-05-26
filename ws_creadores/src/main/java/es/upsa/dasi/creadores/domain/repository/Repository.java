package es.upsa.dasi.creadores.domain.repository;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

import java.util.List;

public interface Repository
{
    List<Creador> getCreadores () throws PodcastsAppException;
    List<Creador> getCreadoresByIds(List<String> ids) throws PodcastsAppException;
}
