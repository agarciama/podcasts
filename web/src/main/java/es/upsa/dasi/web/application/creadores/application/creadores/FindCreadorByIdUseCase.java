package es.upsa.dasi.web.application.creadores.application.creadores.impl;

import es.upsa.dasi.podcasts.domain.entities.Creador;

import java.util.Optional;

public interface FindCreadorByIdUseCase
{
    public Optional<Creador> execute (String id);
}
