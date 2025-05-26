package es.upsa.dasi.podcasts.domain.mappers;

import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import es.upsa.dasi.podcasts.domain.entities.Creador;

public class Mappers
{
    public static Creador toPelicula(CreadorDto creadorDto)
    {
        return Creador.builder()
                .withId(null)
                .withNombre(creadorDto.getNombre())
                .withEmail(creadorDto.getEmail())
                .withBio(creadorDto.getBio())
                .build();
    }
}
