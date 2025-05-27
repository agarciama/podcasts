package es.upsa.dasi.podcasts.domain.exceptions;

public class PodcastsNotFoundException extends NotFoundException{
    public PodcastsNotFoundException() {
        super("El Podcast buscado no existe en la BBDD");
    }
}
