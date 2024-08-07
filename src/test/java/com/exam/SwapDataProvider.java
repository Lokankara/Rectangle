package com.exam;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class SwapDataProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new String[]{"Harry Potter", "Ron Weasley"}, "Potter Harry. Weasley Ron"),
                Arguments.of(new String[]{"Hermione Granger"}, "Granger Hermione"),
                Arguments.of(new String[]{"Albus Dumbledore"}, "Dumbledore Albus"),
                Arguments.of(new String[]{"Severus Snape"}, "Snape Severus"),
                Arguments.of(new String[]{"Minerva McGonagall"}, "McGonagall Minerva")
        );
    }
}
