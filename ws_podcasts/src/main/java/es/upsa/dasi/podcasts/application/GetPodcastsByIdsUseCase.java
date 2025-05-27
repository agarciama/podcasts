package es.upsa.dasi.podcasts.application;

import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

import java.util.List;

public interface GetPodcastsByIdsUseCase
{
    List<Podcast> execute(List<String> ids) throws PodcastsAppException;
}
