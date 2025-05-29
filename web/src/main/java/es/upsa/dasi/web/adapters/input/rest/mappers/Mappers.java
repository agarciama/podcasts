package es.upsa.dasi.web.adapters.input.rest.mappers;

import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import es.upsa.dasi.podcasts.domain.dtos.PodcastDto;
import es.upsa.dasi.web.adapters.input.rest.dtos.CreadorForm;
import es.upsa.dasi.web.adapters.input.rest.dtos.PodcastForm;

import java.time.LocalDate;

public class Mappers
{
    public static CreadorDto toCreadorDto (CreadorForm creadorForm){
        return CreadorDto.builder()
                         .withNombre(creadorForm.getNombre())
                         .withEmail(creadorForm.getEmail())
                         .withBio(creadorForm.getBio())
                         .build();
    }

    public static PodcastDto toPodcastDto (PodcastForm podcastForm){{
    }
        return PodcastDto.builder()
                        .withIdCreador(podcastForm.getIdCreador())
                        .withTitulo(podcastForm.getTitulo())
                        .withDescripcion(podcastForm.getDescripcion())
                        .withFechaInicio(LocalDate.parse(podcastForm.getFechaInicio()))
                        .withImagen(podcastForm.getImagen())
                         .build();
    }
}
