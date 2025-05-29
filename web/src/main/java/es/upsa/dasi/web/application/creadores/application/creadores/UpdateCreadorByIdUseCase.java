package es.upsa.dasi.web.application.creadores.application.creadores;

import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import es.upsa.dasi.podcasts.domain.entities.Creador;

import java.util.Optional;

public interface UpdateCreadorByIdUseCase
{
   Optional<Creador> execute (String id, CreadorDto creadorDto);
}
