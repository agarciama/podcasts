package es.upsa.dasi.web.adapters.input.rest.dtos;

import jakarta.ws.rs.FormParam;
import lombok.Data;

@Data
public class CreadorForm
{
    @FormParam("nombre")
    String nombre;

    @FormParam("email")
    String email;

    @FormParam("bio")
    String bio;
}


