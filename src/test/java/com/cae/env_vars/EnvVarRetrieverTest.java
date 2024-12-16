package com.cae.env_vars;

import com.cae.env_vars.exceptions.MissingEnvVarException;
import com.cae.env_vars.exceptions.UnexpectedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EnvVarRetrieverTest {

    @Test
    void shouldThrowMissingEnvVarExceptionWhenNoEnvVarIsFound(){
        Assertions.assertThrows(
                MissingEnvVarException.class,
                () -> EnvVarRetriever.getEnvVarByName("NON_EXISTENT_ENV_VAR_KEY", String.class)
        );
    }

    @Test
    void shouldReturnTheEnvVarValueWhenExistent(){
        Assertions.assertDoesNotThrow(() -> {
            var value = (EnvVarRetriever.getEnvVarByName("EnvVarOne", String.class));
            Assertions.assertEquals("some-normal-value", value);
        });
    }

    @Test
    void shouldReturnTheEnvVarValueAsString(){
        Assertions.assertDoesNotThrow(() -> {
            var value = (EnvVarRetriever.getEnvVarByNameAsString("EnvVarOne"));
            Assertions.assertEquals("some-normal-value", value);
        });
    }

    @Test
    void shouldReturnTheEnvVarValueAsInteger(){
        Assertions.assertDoesNotThrow(() -> {
            var value = (EnvVarRetriever.getEnvVarByNameAsInteger("EnvVarTwo"));
            Assertions.assertEquals(123, value);
        });
    }

    @Test
    void shouldReturnTheEnvVarValueAsBoolean(){
        Assertions.assertDoesNotThrow(() -> {
            var value = (EnvVarRetriever.getEnvVarByNameAsBoolean("EnvVarThree"));
            Assertions.assertEquals(true, value);
        });
    }

    @Test
    void shouldThrowUnexpectedExceptionWhenSomeProblemHappensOtherThanMissingEnvVar(){
        Assertions.assertThrows(
                UnexpectedException.class,
                () -> EnvVarRetriever.getEnvVarByNameAsInteger("EnvVarThree")
        );
    }

}
