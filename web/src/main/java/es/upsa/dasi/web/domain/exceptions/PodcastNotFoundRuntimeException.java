package es.upsa.dasi.web.domain.exceptions;

import jakarta.ws.rs.NotFoundException;

public class PodcastNotFoundRuntimeException extends NotFoundException
{
    public PodcastNotFoundRuntimeException() {
        super("El Podcast buscado no existe");
    }
}
