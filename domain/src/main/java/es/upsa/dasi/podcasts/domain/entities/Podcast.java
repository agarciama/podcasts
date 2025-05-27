package es.upsa.dasi.podcasts.domain.entities;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@With
@JsonbPropertyOrder({"id","idCreador","titulo","descripcion","fechaInicio","imagen"})
public class Podcast
{
    private String id;
    @JsonbProperty("idCreador")
    private String idCreador;
    private String titulo;
    private String descripcion;
    @JsonbProperty("fechaInicio")
    private LocalDate fechaInicio;
    private String imagen;

}
