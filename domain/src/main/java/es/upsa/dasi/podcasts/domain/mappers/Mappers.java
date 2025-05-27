package es.upsa.dasi.podcasts.domain.mappers;

import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import es.upsa.dasi.podcasts.domain.dtos.PodcastDto;
import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.entities.Podcast;

public class Mappers
{
    public static Creador toCreador(CreadorDto creadorDto)
    {
        return Creador.builder()
                .withId(null)
                .withNombre(creadorDto.getNombre())
                .withEmail(creadorDto.getEmail())
                .withBio(creadorDto.getBio())
                .build();
    }

    public static Podcast toPodcast(PodcastDto podcastDto)
    {
        return Podcast.builder()
                .withId(null)
                .withIdCreador(podcastDto.getIdCreador())
                .withTitulo(podcastDto.getTitulo())
                .withDescripcion(podcastDto.getDescripcion())
                .withFechaInicio(podcastDto.getFechaInicio())
                .withImagen(podcastDto.getImagen())
                .build();
    }

}
