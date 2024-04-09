package com.cae.env_vars.exceptions;

import com.cae.mapped_exceptions.specifics.InternalMappedException;

public class UnexpectedException extends InternalMappedException {
    public <T> UnexpectedException(Exception unexpectedException, String name, Class<T> typeToReturn) {
        super(
                "Something went wrong while trying to retrieve an environment variable",
                "There was a problem trying to retrieve the '" + name + "' environment variable as '" + typeToReturn.getSimpleName() + "': " + unexpectedException.toString()
        );
    }
}
