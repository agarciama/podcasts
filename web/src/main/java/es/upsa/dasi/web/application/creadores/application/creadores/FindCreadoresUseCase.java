package es.upsa.dasi.web.application.creadores.application.creadores.impl;

import es.upsa.dasi.podcasts.domain.entities.Creador;

import java.util.List;

public interface FindCreadoresUseCase
{
    List<Creador> execute();
}
