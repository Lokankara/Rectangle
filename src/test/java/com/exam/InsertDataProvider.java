package com.exam;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class InsertDataProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(new String[]{"harry", "potter"}, "ry", "changed", "harry changed potter"),
                Arguments.of(new String[]{"ron", "weasley"}, "on", "inserted", "ron inserted weasley"),
                Arguments.of(new String[]{"hermione", "granger"}, "ne", "extra", "hermione extra granger"),
                Arguments.of(new String[]{"albus", "dumbledore"}, "us", "added", "albus added dumbledore"),
                Arguments.of(new String[]{"severus", "snape"}, "us", "inserts", "severus inserts snape")
        );
    }
}
