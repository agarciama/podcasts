package es.upsa.dasi.podcasts.domain.exceptions;

public class FieldRequiredSQLException extends PodcastsAppException
{
    public FieldRequiredSQLException(String fieldName) {
        super("El campo " + fieldName + " es obligatorio, no puede ser nulo");
    }
}
