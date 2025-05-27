package es.upsa.dasi.podcasts.domain.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class PodcastDto
{
    private String idCreador;
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private String imagen;

}
