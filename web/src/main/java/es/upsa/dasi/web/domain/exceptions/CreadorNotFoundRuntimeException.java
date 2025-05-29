package es.upsa.dasi.web.domain.exceptions;

import jakarta.ws.rs.NotFoundException;

public class CreadorNotFoundRuntimeException extends NotFoundException
{
    public CreadorNotFoundRuntimeException() {
        super("El Creador buscado no existe");
    }
}
