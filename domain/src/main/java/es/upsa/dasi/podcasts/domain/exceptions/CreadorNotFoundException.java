package es.upsa.dasi.podcasts.domain.exceptions;

public class CreadorNotFoundException extends NotFoundException{
    public CreadorNotFoundException() {
        super("El creador buscado no existe en la BBDD");
    }
}
