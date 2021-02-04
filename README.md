# require

Lightweight assertion library with predefined messages.

[CHANGELOG.md](/CHANGELOG.md)

## Methods

All methods produce exception **IllegalArgumentException** in the case if statement false. All methods return given
value back without any modifications.

| Method                    | Description                 |
|---------------------------|-----------------------------|
| Require.nonNull           | Check if value is not null. |
| Require.nonBlank          | Check if value is not null and not blank, contains any character different from whitespace |
| Require.nonEmpty          | Check if string or collection is not null and not empty |
| Require.length            | Check if value is not null and has length between minLength and maxLength |
| Require.maxLength         | Check if value is not null and has length between 0 and maxLength |
| Require.minLength         | Check if value is not null and has length more then minLength |
| Require.nonBlankMaxLength | Check if value is not blank and has length between 1 and maxLength |
| Require.format            | Check if value is not null and has match regexp pattern format |
| Require.positive          | Check if numeric value is not null and positive |
| Require.negative          | Check if numeric value is not null and negative |
| Require.gtThanZero        | Check if numeric is not null and grate than 0 |
| Require.lsThanZero        | Check if numeric is not null and less than 0 |

## Example

```
public final class RequestId {

    private final String value;

    public RequestId(@Nullable final String value) {
        this.value = Require.nonBlank(value, "requestId");
    }

    @Nonnull
    public String value() {
        return value;
    }
}
```

## Installation

Library is available on [jCenter](https://bintray.com/ilubenets/maven/require).

Gradle:

```
repositories {
    maven { url "https://dl.bintray.com/ilubenets/maven" }
}

dependencies {
    compile 'com.github.ilubenets:require:1.2'
}
```

## Publish to MavenCentral

- check staging repository: [oss.sonatype.org](https://oss.sonatype.org/#stagingRepositories)
- `./gradlew clean build uploadArchives` - upload archives to nexus staging
- `./gradlew closeAndReleaseRepository` – closes and releases a repository (an equivalent to closeRepository and then
  releaseRepository)