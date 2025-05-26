package es.upsa.dasi.podcasts.shared.quarkus.rest.providers;

import es.upsa.dasi.podcasts.shared.quarkus.rest.providers.converters.StringToListOfStringsParamConverter;
import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import jakarta.ws.rs.ext.Provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Provider
public class StringToListParamConverterProvider implements ParamConverterProvider
{
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> aClass, Type type, Annotation[] annotations)
    {
        if (type instanceof ParameterizedType parameterizedType)
        {
            Class rawClass = (Class) parameterizedType.getRawType();
            if ( List.class.isAssignableFrom(rawClass) )
            {
                Class itemClass = (Class) parameterizedType.getActualTypeArguments()[0];
                if (String.class == itemClass) return (ParamConverter<T>) new StringToListOfStringsParamConverter();
            }
        }

        return null;
    }
}
