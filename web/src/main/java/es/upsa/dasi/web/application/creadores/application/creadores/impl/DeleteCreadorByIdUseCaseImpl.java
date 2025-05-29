package es.upsa.dasi.web.application.creadores.application.creadores.impl;

import es.upsa.dasi.web.application.creadores.application.creadores.DeleteCreadorByIdUseCase;
import es.upsa.dasi.web.infrastructure.rest.CreadoresGatewayRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class DeleteCreadorByIdUseCaseImpl implements DeleteCreadorByIdUseCase
{
    @Inject
    @RestClient
    CreadoresGatewayRestClient restClient;

    @Override
    public void execute(String id) {
        restClient.deleteCreadorById(id);
    }
}
