# ☕ cae-utils-env-vars
Welcome to the repository for the open source CAE EnvVars library!

### ▶️ The artifact:
```xml
<dependency>
  <groupId>com.clean-arch-enablers</groupId>
  <artifactId>env-vars</artifactId>
  <version>${version}</version>
</dependency>
```

### 💡 How to use:
The CAE EnvVars library is very simple to use. It is designed to enable you to fetch environment variables for your application at ease, inheriting some validations along the way.

```java
var someEnvironmentVariableValue = EnvVarRetriever.getEnvVarByNameAsString("some_env_var_key");
```
In the snippet above the ```EnvVarRetriever``` is fetching the ```some_env_var_key``` environment variable value and casting it to the ```String``` type.

There are other 2 right out of the box casting methods:

```java
var someEnvironmentVariableValue = EnvVarRetriever.getEnvVarByNameAsInteger("some_env_var_key");
```

```java
var someEnvironmentVariableValue = EnvVarRetriever.getEnvVarByNameAsBoolean("some_env_var_key");
```

And if for some reason you need to specify another type for casting, you are free to do it this way:

```java
var someEnvironmentVariableValue = EnvVarRetriever.getEnvVarByName("some_env_var_key", Long.class);
```

#### MissingEnvVarException & UnexpectedException
For the env var retrievement to function properly, you must provide the env var keys to your application. If you do not provide them, a ```MissingEnvVarException``` will be thrown. Additionally, if anything goes unexpectedly wrong while fetching the values, an instance of ```UnexpectedException``` will be thrown (e.g. you attempt to cast some env var value to some incompatible type).
