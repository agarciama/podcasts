package es.upsa.dasi.podcasts.infrastructure.persistence;

import es.upsa.dasi.podcasts.adapters.output.persistence.Dao;
import es.upsa.dasi.podcasts.domain.entities.Podcast;
import es.upsa.dasi.podcasts.domain.exceptions.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DaoImpl implements Dao
{
    @Inject
    DataSource dataSource;

    @Override
    public List<Podcast> findPodcasts() throws PodcastsAppException {
        final String SQL = """
                           SELECT id, id_creador, titulo, descripcion, fecha_inicio, imagen
                           FROM podcast
                           """;

        List<Podcast> podcasts = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)
        ){
            while (resultSet.next()) {
                podcasts.add(toPodcast(resultSet));
            }

        } catch (SQLException sqlException) {
            throw toPodcastsAppException(sqlException);
        }

        return podcasts;
    }

    @Override
    public List<Podcast> findPodcastsByIds(List<String> ids) throws PodcastsAppException {
        final String SQL = """
                           SELECT id, id_creador, titulo, descripcion, fecha_inicio, imagen
                             FROM podcast
                            WHERE id = ANY(?)
                           """;


        List<Podcast> podcasts = new ArrayList<>();


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
                    podcasts.add( toPodcast(resultSet) );
                }

                if (podcasts.isEmpty()) throw new CreadorNotFoundException();
            }

        } catch (SQLException sqlException)
        {
            throw toPodcastsAppException(sqlException);
        }
        return podcasts;
    }

    @Override
    public Optional<Podcast> findPodcastById(String id) throws PodcastsAppException {
        final String SQL = """
                           SELECT id, id_creador, titulo, descripcion, fecha_inicio, imagen
                             FROM podcast
                            WHERE id = ?
                           """;


        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)
        )
        {
            preparedStatement.setString(1, id);

            try(ResultSet resultSet = preparedStatement.executeQuery())
            {
                return ( !resultSet.next() )? Optional.empty() : Optional.of( toPodcast(resultSet) );
            }

        } catch (SQLException sqlException)
        {
            throw toPodcastsAppException(sqlException);
        }
    }

    @Override
    public List<Podcast> findPodcastsByCreadorId(String ids) throws PodcastsAppException
    {
        final String SQL = """
                           SELECT id, id_creador, titulo, descripcion, fecha_inicio, imagen
                             FROM podcast
                            WHERE id_creador = ?
                           """;

        List<Podcast> podcasts = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)
        )
        {
            preparedStatement.setString(1, ids);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    podcasts.add( toPodcast(resultSet) );
                }
                if (podcasts.isEmpty()) throw new NotFoundPodcastWithThatCreadorId();
            }


        } catch (SQLException sqlException)
        {
            throw toPodcastsAppException(sqlException);
        }

        return podcasts;

    }


    private Podcast toPodcast(ResultSet resultSet) throws SQLException {
        return Podcast.builder()
                      .withId(resultSet.getString(1))
                      .withId_creador(resultSet.getString(2))
                      .withTitulo(resultSet.getString(3))
                      .withDescripcion(resultSet.getString(4))
                      .withFecha_inicio(resultSet.getDate(5).toLocalDate())
                      .withImagen(resultSet.getString(6))
                      .build();
    }


    private PodcastsAppException toPodcastsAppException(SQLException sqlException)
    {
        String message = sqlException.getMessage();
        if      ( message.contains("NN_PODCAST.ID_CREADOR")   ) return new FieldRequiredSQLException("id_creador");
        if      ( message.contains("NN_PODCAST.TITULO")   ) return new FieldRequiredSQLException("titulo");
        if      ( message.contains("NN_PODCAST.DESCRIPCION")   ) return new FieldRequiredSQLException("descripcion");
        if      ( message.contains("NN_PODCAST.FECHA_INICIO")   ) return new FieldRequiredSQLException("fecha_inicio");
        if      ( message.contains("NN_PODCAST.IMAGEN")   ) return new FieldRequiredSQLException("imagen");
        if      ( message.contains("FK_EPISODIO_PODCAST")   ) return new PodcastHasEpisodesException();


        return new SQLPodcastsNotControlledException(sqlException);
    }


}
