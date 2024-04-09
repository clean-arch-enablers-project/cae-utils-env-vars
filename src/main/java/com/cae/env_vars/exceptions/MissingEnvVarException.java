package com.cae.env_vars.exceptions;

import com.cae.mapped_exceptions.specifics.InternalMappedException;

public class MissingEnvVarException extends InternalMappedException {
    public MissingEnvVarException(String missingEnvironmentVariableName) {
        super(
                "Missing environment variable",
                "The environment variable '" + missingEnvironmentVariableName + "' was not present"
        );
    }
}
