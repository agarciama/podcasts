package es.upsa.dasi.web.application;

import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

import java.util.List;

public interface FindCreadoresUseCase
{
    List<Creador> execute() throws PodcastsAppException;
}
