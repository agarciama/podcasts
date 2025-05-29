package es.upsa.dasi.web.infrastructure.rest.providers;

import es.upsa.dasi.podcasts.domain.dtos.ErrorDto;
import es.upsa.dasi.podcasts.domain.exceptions.CreadorNotFoundException;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.podcasts.domain.exceptions.RestClientAppException;
import es.upsa.dasi.web.domain.exceptions.CreadorNotFoundRuntimeException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;


public class CreadoresResponseExceptionMapper implements ResponseExceptionMapper<WebApplicationException> {
    @Override
    public WebApplicationException toThrowable(Response response)
    {
        switch (response.getStatusInfo().toEnum()) {
            case NOT_FOUND: return new CreadorNotFoundRuntimeException();

            default:
                ErrorDto errorDto = response.readEntity(ErrorDto.class);
                return new InternalServerErrorException(errorDto.getMessage());

        }
    }
}
