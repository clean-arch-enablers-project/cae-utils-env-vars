package com.cae.env_vars;

import com.cae.env_vars.exceptions.MissingEnvVarException;
import com.cae.env_vars.exceptions.UnexpectedException;
import com.cae.trier.Trier;

import java.util.Optional;

public class EnvVarRetriever {

    private EnvVarRetriever(){}

    public static String getEnvVarByNameAsString(String name){
        return EnvVarRetriever.getEnvVarByName(name, String.class);
    }

    public static Integer getEnvVarByNameAsInteger(String name){
        return Trier.of(() -> Integer.valueOf(EnvVarRetriever.getEnvVarByNameAsString(name)))
                .setUnexpectedExceptionHandler(unexpected -> new UnexpectedException(unexpected, name, Integer.class))
                .execute();
    }

    public static Boolean getEnvVarByNameAsBoolean(String name){
        return Trier.of(() -> Boolean.valueOf(EnvVarRetriever.getEnvVarByNameAsString(name)))
                .setUnexpectedExceptionHandler(unexpected -> new UnexpectedException(unexpected, name, Boolean.class))
                .execute();
    }

    public static <T> T getEnvVarByName(String name, Class<T> typeToReturn){
        return Trier.of(() -> EnvVarRetriever.tryToGetEnvVar(name, typeToReturn))
                .setUnexpectedExceptionHandler(unexpectedException -> new UnexpectedException(unexpectedException, name, typeToReturn))
                .execute();
    }

    private static <T> T tryToGetEnvVar(String name, Class<T> typeToReturn) {
        return Optional.ofNullable(System.getenv(name))
                .map(typeToReturn::cast)
                .orElseThrow(() -> new MissingEnvVarException(name));
    }

}
