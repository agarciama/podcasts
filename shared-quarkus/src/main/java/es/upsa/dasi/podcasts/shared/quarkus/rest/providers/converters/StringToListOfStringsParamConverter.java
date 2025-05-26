package es.upsa.dasi.podcasts.shared.quarkus.rest.providers.converters;

import jakarta.ws.rs.ext.ParamConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToListOfStringsParamConverter implements ParamConverter<List<String>>
{
    @Override
    public List<String> fromString(String value)
    {
        if ("".equals(value)) return List.of();

        String[] tokens = value.split(",");
        return Arrays.stream( tokens )
                .map(token -> token.trim())
                .toList();
    }

    @Override
    public String toString(List<String> tokens)
    {
        return tokens.stream()
                .map( String::trim )
                .collect( Collectors.joining(",") );
    }
}
