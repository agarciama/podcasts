package es.upsa.dasi.creadores.application.impl;

import es.upsa.dasi.creadores.application.RemoveCreadorUseCase;
import es.upsa.dasi.creadores.domain.repository.Repository;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RemoveCreadorUseCaseImpl implements RemoveCreadorUseCase
{
    @Inject
    Repository repository;

    @Override
    public void execute(String id) throws PodcastsAppException {
        repository.removeCreadorById(id);
    }
}
