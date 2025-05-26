package es.upsa.dasi.podcasts.infrastructure.persistence;

import es.upsa.dasi.podcasts.adapters.output.persistence.Dao;
import es.upsa.dasi.podcasts.domain.exceptions.FieldRequiredSQLException;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.podcasts.domain.exceptions.SQLPodcastsNotControlledException;

import java.sql.SQLException;

public class DaoImpl implements Dao
{



    private PodcastsAppException toPodcastsAppException(SQLException sqlException)
    {
        String message = sqlException.getMessage();
        if      ( message.contains("NN_PODCAST.ID_CREADOR")   ) return new FieldRequiredSQLException("id_creador");
        if      ( message.contains("NN_PODCAST.TITULO")   ) return new FieldRequiredSQLException("titulo");
        if      ( message.contains("NN_PODCAST.DESCRIPCION")   ) return new FieldRequiredSQLException("descripcion");
        if      ( message.contains("NN_PODCAST.FECHA_INICIO")   ) return new FieldRequiredSQLException("fecha_inicio");
        if      ( message.contains("NN_PODCAST.IMAGEN")   ) return new FieldRequiredSQLException("imagen");

        return new SQLPodcastsNotControlledException(sqlException);
    }

}
