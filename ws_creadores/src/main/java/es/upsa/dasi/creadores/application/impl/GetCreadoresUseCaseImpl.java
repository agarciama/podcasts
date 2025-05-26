package es.upsa.dasi.creadores.application.impl;

import es.upsa.dasi.creadores.application.GetCreadoresUseCase;
import es.upsa.dasi.creadores.domain.repository.Repository;
import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GetCreadoresUseCaseImpl implements GetCreadoresUseCase
{
    @Inject
    Repository repository;

    @Override
    public List<Creador> execute() throws PodcastsAppException {
        return repository.getCreadores();
    }
}
