package es.upsa.dasi.creadores.application.impl;

import es.upsa.dasi.creadores.application.AddCreadorUseCase;
import es.upsa.dasi.creadores.domain.repository.Repository;
import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AddCreadorUseCaseImpl implements AddCreadorUseCase
{
    @Inject
    Repository repository;

    @Override
    public Creador execute(Creador creador) throws PodcastsAppException {
        return repository.addCreador(creador);
    }
}
