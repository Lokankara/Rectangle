package com.exam;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class ReplaceDataProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new String[]{"harry", "potter"}, List.of("harry", "snape"), "snape", 6),
                Arguments.of(new String[]{"ron", "weasley"}, List.of("ron", "potter"), "potter", 7),
                Arguments.of(new String[]{"hermi", "granger"}, List.of("hermi", "granger"), "weasley", 8),
                Arguments.of(new String[]{"albus", "dumbledore"}, List.of("harry", "dumbledore"), "harry", 5),
                Arguments.of(new String[]{"severus", "snape"}, List.of("severus", "snape"), "snape", 8)
        );
    }
}
