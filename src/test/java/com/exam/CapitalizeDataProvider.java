package com.exam;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CapitalizeDataProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new String[]{"harry", "potter"}, new String[]{"Harry", "Potter"}),
                Arguments.of(new String[]{"ron", "weasley"}, new String[]{"Ron", "Weasley"}),
                Arguments.of(new String[]{"hermione", "granger"}, new String[]{"Hermione", "Granger"}),
                Arguments.of(new String[]{"albus", "dumbledore"}, new String[]{"Albus", "Dumbledore"}),
                Arguments.of(new String[]{"severus", "snape"}, new String[]{"Severus", "Snape"})
        );
    }
}
