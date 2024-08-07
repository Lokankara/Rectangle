package com.exam;

import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class StringApiTest {

    StringApi api = new StringApi();

    @ParameterizedTest(name = "{index} - {3}")
    @ArgumentsSource(CapitalizeDataProvider.class)
    @DisplayName("Capitalize the first letter of each word in the given text.")
    void testCapitalize(String[] actual, String[] expected) {
        String result = api.capitalize(actual);
        assertEquals(String.join(" ", expected), result);
    }

    @ParameterizedTest(name = "{index} - {4}")
    @ArgumentsSource(ReplaceDataProvider.class)
    @DisplayName("Replace words of the given length with the specified substring.")
    void testReplace(String[] actual, List<String> expectedList, String expected, int expectedInt) {
        List<String> result = api.replace(actual, expectedInt, expected);
        assertEquals(expectedList, result);
    }

    @ParameterizedTest(name = "{index} - {4}")
    @ArgumentsSource(InsertDataProvider.class)
    @DisplayName("Insert the specified substring after each word ending with the specified substring.")
    void testInsert(String[] actual, String syllable, String insert, String expected) {
        String result = api.insert(actual, syllable, insert);
        assertEquals(expected, result);
    }

//    @ParameterizedTest(name = "{index} - {4}")
    @ArgumentsSource(LongerDataProvider.class)
    @DisplayName("Insert the specified substring after each word longer than the specified length.")
    void testCompareGreaterThen(String[] actual, List<String> expectedList, String expected, int expectedInt) {
        List<String> result = api.compareGreaterThen(actual, expectedInt, expected);
        assertEquals(expectedList, result);
    }

    @ParameterizedTest(name = "{index} - {2}")
    @ArgumentsSource(CreateDataProvider.class)
    @DisplayName("Create collections of text words with minimum and maximum lengths.")
    void testTask6(String[] actual, Map<String, List<String>> expectedMap) {
        Map<String, List<String>> result = api.create(actual);
        assertEquals(expectedMap.get("min"), result.get("min"));
        assertEquals(expectedMap.get("max"), result.get("max"));
    }

    @ParameterizedTest(name = "{index} - {1}")
    @ArgumentsSource(SwapDataProvider.class)
    @DisplayName("Swap the first and last words in each sentence of the text.")
    void testSwap(String[] actual, String expected) {
        String result = api.swap(actual);
        assertEquals(expected, result);
    }

//    @ParameterizedTest(name = "{index} - {1}")
    @ArgumentsSource(FIFODataProvider.class)
    @DisplayName("FIFO the first and last words in each sentence of the text.")
    void testSwap(String[] actual, Set<String> expected) {
        Set<String> result = api.matchFIFO(actual);
        assertEquals(expected, result);
    }
}