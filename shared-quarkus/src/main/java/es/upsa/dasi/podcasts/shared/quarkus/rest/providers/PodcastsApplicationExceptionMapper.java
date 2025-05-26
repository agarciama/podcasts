package es.upsa.dasi.podcasts.shared.quarkus.rest.providers;

import es.upsa.dasi.podcasts.domain.dtos.ErrorDto;
import es.upsa.dasi.podcasts.domain.exceptions.NotFoundException;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class PodcastsApplicationExceptionMapper implements ExceptionMapper<PodcastsAppException> {
    @Override
    public Response toResponse(PodcastsAppException exception) {
        String message = exception.getMessage();

        Response.Status status = (exception instanceof NotFoundException) ? Response.Status.NOT_FOUND : Response.Status.INTERNAL_SERVER_ERROR;

        return Response.status(status)
                .entity( ErrorDto.builder()
                        .withMessage( message )
                        .build()
                )
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
