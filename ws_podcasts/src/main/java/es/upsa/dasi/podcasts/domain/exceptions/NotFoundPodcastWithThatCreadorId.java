package es.upsa.dasi.podcasts.domain.exceptions;

public class NotFoundPodcastWithThatCreadorId extends NotFoundException{
    public NotFoundPodcastWithThatCreadorId() {
        super("No se ha enncontrado ningun Podcasts para el creador seleccionado");
    }
}
