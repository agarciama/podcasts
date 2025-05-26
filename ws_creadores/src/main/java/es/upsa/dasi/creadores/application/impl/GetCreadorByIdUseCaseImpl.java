package es.upsa.dasi.creadores.application.impl;

import es.upsa.dasi.creadores.application.GetCreadorByIdUseCase;
import es.upsa.dasi.creadores.domain.repository.Repository;
import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class GetCreadorByIdUseCaseImpl implements GetCreadorByIdUseCase
{

    @Inject
    Repository repository;

    @Override
    public Optional<Creador> execute(String id) throws PodcastsAppException {
        return repository.getCreadorById(id);
    }
}
