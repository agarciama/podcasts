package es.upsa.dasi.podcasts.domain.exceptions;

public class PodcastsNotFoundException extends NotFoundException{
    public PodcastsNotFoundException(String message) {
        super("El Podcast buscado no existe en la BBDD");
    }
}
