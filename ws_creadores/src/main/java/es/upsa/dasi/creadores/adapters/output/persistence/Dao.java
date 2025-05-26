package es.upsa.dasi.creadores.adapters.output.persistence;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

import java.util.List;

public interface Dao
{
    List<Creador> findCreadores() throws PodcastsAppException;
}
