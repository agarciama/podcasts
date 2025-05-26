package es.upsa.dasi.creadores.infrastructure.persistence;

import es.upsa.dasi.creadores.adapters.output.persistence.Dao;
import es.upsa.dasi.creadores.domain.exceptions.CreadorHasPodcastException;
import es.upsa.dasi.podcasts.domain.entities.Creador;
import es.upsa.dasi.podcasts.domain.exceptions.CreadorNotFoundException;
import es.upsa.dasi.podcasts.domain.exceptions.FieldRequiredSQLException;
import es.upsa.dasi.podcasts.domain.exceptions.PodcastsAppException;
import es.upsa.dasi.podcasts.domain.exceptions.SQLPodcastsNotControlledException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class DaoImpl implements Dao
{
    @Inject
    DataSource dataSource;

    @Override
    public List<Creador> findCreadores() throws PodcastsAppException {

        final String SQL = """
                           SELECT id, nombre, email, bio
                           FROM creador
                           """;

        List<Creador> creadores = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)
        ){
            while (resultSet.next()) {
                creadores.add(toCreador(resultSet));
            }

        } catch (SQLException sqlException) {
            throw toPodcastsAppException(sqlException);
        }

        return creadores;

    }

    @Override
    public List<Creador> findCreadoresByIds(List<String> ids) throws PodcastsAppException {
        final String SQL = """
                           SELECT c.id, c.nombre, c.email, c.bio
                             FROM creador c
                            WHERE c.id = ANY(?)
                           """;
        List<Creador> creadores = new ArrayList<>();


        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)
        )
        {
            Array arrIds = connection.createArrayOf("VARCHAR", ids.toArray());

            preparedStatement.setArray(1, arrIds);

            try(ResultSet resultSet = preparedStatement.executeQuery())
            {
                while (resultSet.next())
                {
                    creadores.add( toCreador(resultSet) );
                }

                if (creadores.isEmpty()) throw new CreadorNotFoundException();
            }

        } catch (SQLException sqlException)
        {
            throw toPodcastsAppException(sqlException);
        }
        return creadores;
    }


    private Creador toCreador(ResultSet resultSet) throws SQLException
    {
        return Creador.builder()
                        .withId(resultSet.getString(1) )
                        .withNombre(resultSet.getString(2))
                        .withEmail(resultSet.getString(3))
                        .withBio(resultSet.getString(4))
                        .build();
    }

    private PodcastsAppException toPodcastsAppException(SQLException sqlException)
    {
        String message = sqlException.getMessage();

        if      ( message.contains("NN_CREADOR.NOMBRE")   ) return new FieldRequiredSQLException("nombre");
        if      ( message.contains("NN_CREADOR.EMAIL")   ) return new FieldRequiredSQLException("email");
        if      ( message.contains("FK_PODCAST_CREADOR")   ) return new CreadorHasPodcastException();


        return new SQLPodcastsNotControlledException(sqlException);
    }

}
