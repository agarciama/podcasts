package es.upsa.dasi.web.adapters.input.rest.dtos;

import jakarta.ws.rs.FormParam;
import lombok.Data;

@Data
public class PodcastForm
{
    @FormParam("titulo")
    String titulo;

    @FormParam("idCreador")
    String idCreador;

    @FormParam("descripcion")
    String descripcion;

    @FormParam("fechaInicio")
    String fechaInicio;

    @FormParam("imagen")
    String imagen;
}
