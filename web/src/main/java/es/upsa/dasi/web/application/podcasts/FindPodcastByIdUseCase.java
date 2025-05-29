package es.upsa.dasi.web.application.podcasts;

import es.upsa.dasi.podcasts.domain.entities.Podcast;

import java.util.Optional;

public interface FindPodcastByIdUseCase
{
    Optional<Podcast> execute(String id);
}
