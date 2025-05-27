package es.upsa.dasi.podcasts.domain.entities;

import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@With
@JsonbPropertyOrder({"id","id_creador","titulo","descripcion","fecha_inicio","imagen"})
public class Podcast
{
    private String id;
    private String id_creador;
    private String titulo;
    private String descripcion;
    private LocalDate fecha_inicio;
    private String imagen;

}
