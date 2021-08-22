# URI Builder

![Java CI](https://github.com/GoodforGod/uri-builder/workflows/Java%20CI/badge.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=GoodforGod_uri-builder&metric=alert_status)](https://sonarcloud.io/dashboard?id=GoodforGod_uri-builder)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=GoodforGod_uri-builder&metric=coverage)](https://sonarcloud.io/dashboard?id=GoodforGod_uri-builder)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=GoodforGod_uri-builder&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=GoodforGod_uri-builder)

Little library with helper for building URI in Java easier.

Library supposed to move URIBuilder functionality out of Micronaut, so it can be reusable in non Micronaut applications.

## Dependency :rocket:

[**Gradle**](https://mvnrepository.com/artifact/com.github.goodforgod/uri-builder)
```groovy
dependencies {
    compile 'com.github.goodforgod:uri-builder:1.0.0'
}
```

[**Maven**](https://mvnrepository.com/artifact/com.github.goodforgod/uri-builder)
```xml
<dependency>
    <groupId>com.github.goodforgod</groupId>
    <artifactId>uri-builder</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

```java
URIBuilder.of("https://api.etherscan.io").path("/api")
                .queryParam("module", "block")
                .queryParam("action", "getblockreward")
                .build()
```

## License

This project licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details