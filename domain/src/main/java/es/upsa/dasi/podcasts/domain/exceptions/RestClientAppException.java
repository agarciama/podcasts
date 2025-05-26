package es.upsa.dasi.podcasts.domain.exceptions;

public class RestClientAppException extends PodcastsAppException
{
    public RestClientAppException(String message) {
        super(message);
    }
}
