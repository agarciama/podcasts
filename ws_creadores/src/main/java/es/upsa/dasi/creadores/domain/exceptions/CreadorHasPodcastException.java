package es.upsa.dasi.creadores.domain.exceptions;

import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;

public class CreadorHasPodcastException extends PodcastsAppException
{
    public CreadorHasPodcastException() {
        super("El creador tiene podcast/s asociados");
    }
}
