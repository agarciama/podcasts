package es.upsa.dasi.web.application.creadores;

import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import es.upsa.dasi.podcasts.domain.entities.Creador;

public interface InsertCreadorByIdUseCase
{
    Creador execute(CreadorDto creadorDto);
}
