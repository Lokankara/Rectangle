package com.exam;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CreateDataProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(new String[]{"harry", "potter"}, Map.of(
                        "min", List.of("harry"),
                        "max", List.of("potter")
                )),
                Arguments.of(new String[]{"ron", "weasley"}, Map.of(
                        "min", List.of("ron"),
                        "max", List.of("weasley")
                )),
                Arguments.of(new String[]{"hermione", "granger"}, Map.of(
                        "min", List.of("granger"),
                        "max", List.of("hermione")
                )),
                Arguments.of(new String[]{"albus", "dumbledore"}, Map.of(
                        "min", List.of("albus"),
                        "max", List.of("dumbledore")
                )),
                Arguments.of(new String[]{"severus", "snape"}, Map.of(
                        "min", List.of("snape"),
                        "max", List.of("severus")
                ))
        );
    }
}
