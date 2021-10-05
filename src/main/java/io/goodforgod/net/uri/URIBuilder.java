package io.goodforgod.net.uri;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Helper for building URI (Inspired by Micronaut UriBuilder)
 *
 * @author Anton Kurako (GoodforGod)
 * @since 21.08.2021
 */
public interface URIBuilder {

    /**
     * Sets the URI fragment.
     *
     * @param fragment The fragment
     * @return This builder
     */
    @NotNull
    URIBuilder fragment(@Nullable String fragment);

    /**
     * Sets the URI scheme.
     *
     * @param scheme The scheme
     * @return This builder
     */
    @NotNull
    URIBuilder scheme(@Nullable String scheme);

    /**
     * Sets the URI user info.
     *
     * @param userInfo The use info
     * @return This builder
     */
    @NotNull
    URIBuilder userInfo(@Nullable String userInfo);

    /**
     * Sets the URI host.
     *
     * @param host The host to use
     * @return This builder
     */
    @NotNull
    URIBuilder host(@Nullable String host);

    /**
     * Sets the URI port.
     *
     * @param port The port to use
     * @return This builder
     */
    @NotNull
    URIBuilder port(int port);

    /**
     * Appends the given path to the existing path correctly handling '/'. If path
     * is null it is simply ignored.
     *
     * @param path The path
     * @return This builder
     */
    @NotNull
    URIBuilder path(@Nullable String path);

    /**
     * Replaces the existing path if any. If path is null it is simply ignored.
     *
     * @param path The path
     * @return This builder
     */
    @NotNull
    URIBuilder replacePath(@Nullable String path);

    /**
     * Adds a query parameter for the give name and values. The values will be URI
     * encoded. If either name or values are null the value will be ignored.
     *
     * @param name   The name
     * @param values The values
     * @return This builder
     */
    @NotNull
    URIBuilder queryParam(String name, @NotNull String... values);

    /**
     * Adds a query parameter for the give name and values. The values will be URI
     * encoded. If either name or values are null the value will be ignored.
     *
     * @param name   The name
     * @param values The values with be converted to String via
     *               {@link String#valueOf(Object)}
     * @return This builder
     */
    @NotNull
    default URIBuilder queryParam(String name, @NotNull Object... values) {
        final String[] valuesAsStrings = Arrays.stream(values)
                .flatMap(v -> (v instanceof Collection)
                        ? ((Collection<?>) v).stream()
                        : Stream.of(v))
                .map(String::valueOf)
                .toArray(String[]::new);

        return queryParam(name, valuesAsStrings);
    }

    /**
     * Adds a query parameter for the give name and values. The values will be URI
     * encoded. If either name or values are null the value will be ignored.
     *
     * @param name   The name
     * @param values The values
     * @return This builder
     */
    @NotNull
    URIBuilder replaceQueryParam(String name, @NotNull String... values);

    /**
     * Adds a query parameter for the give name and values. The values will be URI
     * encoded. If either name or values are null the value will be ignored.
     *
     * @param name   The name
     * @param values The values with be converted to String via
     *               {@link String#valueOf(Object)}
     * @return This builder
     */
    @NotNull
    default URIBuilder replaceQueryParam(String name, @NotNull Object... values) {
        final String[] valuesAsStrings = Arrays.stream(values)
                .flatMap(v -> (v instanceof Collection)
                        ? ((Collection<?>) v).stream()
                        : Stream.of(v))
                .map(String::valueOf)
                .toArray(String[]::new);

        return replaceQueryParam(name, valuesAsStrings);
    }

    /**
     * The constructed URI.
     *
     * @return Build the URI
     * @throws IllegalArgumentException if the URI to be constructed is invalid
     */
    @NotNull
    URI build();

    /**
     * Create a {@link URIBuilder} with the given base URI as a starting point.
     *
     * @param uri The URI
     * @return The builder
     */
    static @NotNull URIBuilder of(@NotNull URI uri) {
        Objects.requireNonNull(uri);
        return new DefaultURIBuilder(uri);
    }

    /**
     * Create a {@link URIBuilder} with the given base URI as a starting point.
     *
     * @param uri The URI
     * @return The builder
     */
    static @NotNull URIBuilder of(@NotNull CharSequence uri) {
        Objects.requireNonNull(uri);
        return new DefaultURIBuilder(uri);
    }
}
