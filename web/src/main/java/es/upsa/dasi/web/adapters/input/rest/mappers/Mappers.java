package es.upsa.dasi.web.adapters.input.rest.mappers;

import es.upsa.dasi.podcasts.domain.dtos.CreadorDto;
import es.upsa.dasi.web.adapters.input.rest.dtos.CreadorForm;

public class Mappers
{
    public static CreadorDto toCreadorDto (CreadorForm creadorForm){
        return CreadorDto.builder()
                         .withNombre(creadorForm.getNombre())
                         .withEmail(creadorForm.getEmail())
                         .withBio(creadorForm.getBio())
                         .build();
    }
}
