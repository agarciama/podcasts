package es.upsa.dasi.podcasts.domain.entities;


import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.*;


@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@JsonbPropertyOrder({ "id", "nombre", "email", "bio" })
@With
public class Creador
{
    private String id;
    private String nombre;
    private String email;
    private String bio;
}
