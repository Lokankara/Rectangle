package com.exam;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class LongerDataProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new String[]{"harry", "potter"}, List.of("harry", "snape"), " snape", 4),
                Arguments.of(new String[]{"ron", "weasley"}, List.of("ron potter", "weasley potter"), " potter", 6),
                Arguments.of(new String[]{"hermione", "granger"}, List.of("hermione", "granger potter"), " weasley", 6),
                Arguments.of(new String[]{"albus", "dumbledore"}, List.of("albus snape", "dumbledore snape"), " snape", 5),
                Arguments.of(new String[]{"snape", "severus"}, List.of("severus weasley", "snape weasley"), " weasley", 7)
        );
    }
}
