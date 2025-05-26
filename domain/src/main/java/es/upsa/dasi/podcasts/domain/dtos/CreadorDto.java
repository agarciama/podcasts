package es.upsa.dasi.podcasts.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class CreadorDto
{
    private String nombre;
    private String email;
    private String bio;

}
