package es.upsa.dasi.web.application.podcasts;

import es.upsa.dasi.podcasts.domain.dtos.PodcastDto;
import es.upsa.dasi.podcasts.domain.entities.Podcast;

import java.util.Optional;

public interface UpdatePodcastByIdUseCase
{
    Optional<Podcast> execute (String id, PodcastDto podcastDto);
}
