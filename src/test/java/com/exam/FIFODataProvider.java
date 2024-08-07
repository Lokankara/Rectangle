package com.exam;

import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class FIFODataProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new String[]{"harry", "harry"}, Set.of("harry")),
                Arguments.of(new String[]{"ron", "ron"}, Set.of("ron")),
                Arguments.of(new String[]{"hermione", "hermione"}, Set.of("hermione")),
                Arguments.of(new String[]{"albus", "albus"}, Set.of("albus")),
                Arguments.of(new String[]{"severus", "severus"}, Set.of("severus"))
        );
    }
}
