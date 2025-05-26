package es.upsa.dasi.podcasts.domain.exceptions;

public class PodcastsAppException extends Exception
{
    public PodcastsAppException() {
    }

    public PodcastsAppException(String message) {
        super(message);
    }

    public PodcastsAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public PodcastsAppException(Throwable cause) {
        super(cause);
    }

    public PodcastsAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
