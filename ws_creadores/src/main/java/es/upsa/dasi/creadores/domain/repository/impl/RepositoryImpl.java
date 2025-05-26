package es.upsa.dasi.creadores.domain.repository.impl;

import es.upsa.dasi.creadores.adapters.output.persistence.Dao;
import es.upsa.dasi.creadores.domain.repository.Repository;
import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RepositoryImpl implements Repository
{
    @Inject
    Dao dao;

    @Override
    public List<Creador> getCreadores() throws PodcastsAppException {
        return dao.findCreadores();
    }

    @Override
    public List<Creador> getCreadoresByIds(List<String> ids) throws PodcastsAppException {
        return dao.findCreadoresByIds(ids);
    }

    @Override
    public Optional<Creador> getCreadorById(String id) throws PodcastsAppException {
        return dao.findCreadorById(id);
    }

    @Override
    public Creador addCreador(Creador creador) throws PodcastsAppException {
       return dao.insertCreador(creador);
    }
}
