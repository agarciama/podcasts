package es.upsa.dasi.web.application.podcasts;

import es.upsa.dasi.podcasts.domain.entities.Podcast;

import java.util.List;

public interface FindPodcastUseCase
{
    List<Podcast> execute();
}
