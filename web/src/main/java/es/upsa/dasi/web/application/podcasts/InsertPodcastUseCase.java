package es.upsa.dasi.web.application.podcasts;


import es.upsa.dasi.podcasts.domain.dtos.PodcastDto;
import es.upsa.dasi.podcasts.domain.entities.Podcast;

public interface InsertPodcastUseCase
{
    Podcast execute(PodcastDto podcastDto);
}
