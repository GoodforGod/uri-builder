# URI Builder

Little library with helper for building URI in Java easier.

Library supposed to move URIBuilder functionality out of Micronaut, so it can be reusable in non Micronaut applications.

## Dependency :rocket:

**Gradle**
```groovy
dependencies {
    compile 'com.github.goodforgod:uri-builder:1.0.0'
}
```

**Maven**
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