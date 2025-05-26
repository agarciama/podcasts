package es.upsa.dasi.podcasts.domain.entities;


import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@JsonbPropertyOrder({ "id", "nombre", "email", "bio" })
public class Creador
{
    private String id;
    private String nombre;
    private String email;
    private String bio;
}
