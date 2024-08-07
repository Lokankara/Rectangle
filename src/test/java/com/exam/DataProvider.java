package com.exam;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class DataProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(
                        List.of("apple", "banana", "cherry"),
                        List.of("Apple", "Banana", "Cherry"),
                        "Apple Banana Cherry",
                        0,
                        Map.of()
                ),
                Arguments.of(
                        List.of("apple", "banana", "cherry"),
                        List.of("apple", "banana", "cherry"),
                        "apple banana cherry",
                        5,
                        Map.of()
                ),
                Arguments.of(
                        List.of("hello", "world", "java"),
                        List.of("hello", "world", "java"),
                        "hello world rocks java",
                        0,
                        Map.of()
                ),
                Arguments.of(
                        List.of("java", "is", "fun"),
                        List.of("javaawesome", "is", "fun"),
                        "javaawesome is fun",
                        2,
                        Map.of()
                ),
                Arguments.of(
                        List.of("apple", "banana", "cherry"),
                        List.of("apple", "banana"),
                        "apple banana",
                        0,
                        Map.of()
                ),
                Arguments.of(
                        List.of("apple", "banana", "cherry", "kiwi", "blueberry"),
                        List.of("kiwi", "apple"),
                        "kiwi apple",
                        0,
                        Map.of(
                                "min", List.of("kiwi", "apple"),
                                "max", List.of("blueberry", "banana", "cherry")
                        )
                ),
                Arguments.of(
                        List.of("the apple", "is a fruit"),
                        List.of("fruit a is apple the"),
                        "fruit a is apple the",
                        0,
                        Map.of()
                )
        );
    }
}