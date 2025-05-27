package es.upsa.dasi.podcasts.domain.exceptions;

public class PodcastHasEpisodesException extends PodcastsAppException
{
    public PodcastHasEpisodesException() {
        super("El podcast tiene episodios asociados y no se puede eliminar");
    }
}
