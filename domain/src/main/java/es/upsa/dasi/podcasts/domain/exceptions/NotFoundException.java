package es.upsa.dasi.podcasts.domain.exceptions;

public class NotFoundException extends PodcastsAppException
{
    public NotFoundException(String message) {
        super(message);
    }
}
