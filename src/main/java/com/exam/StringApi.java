package com.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StringApi {

    public String capitalize(String[] words) {
        return String.join(" ",
                Arrays.stream(words)
                        .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                        .toArray(String[]::new));
    }

    public List<String> replace(String[] words, int length, String insert) {
        return Arrays.stream(words)
                .map(word -> word.length() == length ? insert : word)
                .collect(Collectors.toList());
    }

    public String insert(String[] words, String syllable, String insert) {
        return String.join(" ", Arrays.stream(words)
                .map(word -> word.endsWith(syllable) ? word + " " + insert : word)
                .toArray(String[]::new));
    }

    public List<String> compareGreaterThen(String[] words, int k, String insert) {
        return Arrays.stream(words)
                .map(word -> word.length() > k ? word.substring(0, k) + insert + word.substring(k) : word)
                .collect(Collectors.toList());
    }

    public Set<String> matchFIFO(String[] words) {
        return Arrays.stream(words)
                .filter(word -> !word.isEmpty() &&
                        word.charAt(0) == word.charAt(word.length() - 1))
                .collect(Collectors.toSet());
    }

    public Map<String, List<String>> create(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int size = words.length;
        String[] first = Arrays.copyOfRange(words, 0, (size + 1) / 2);
        String[] second = Arrays.copyOfRange(words, (size + 1) / 2, size);
        List<String> min = Arrays.asList(first);
        List<String> max = Arrays.asList(second);
        Map<String, List<String>> result = new HashMap<>();
        result.put("min", min);
        result.put("max", max);
        return result;
    }

    public String swap(String[] sentences) {
        return Arrays.stream(sentences)
                .map(sentence -> {
                    String[] words = sentence.split(" ");
                    String last = words[words.length - 1];
                    String first = words[0];
                    words[words.length - 1] = first;
                    words[0] = last;
                    return String.join(" ", words);
                })
                .collect(Collectors.joining(". "));
    }

    public String change(String sentence) {
        String[] words = sentence.split(" ");
        if (words.length > 1) {
            String last = words[words.length - 1];
            String first = words[0];
            words[words.length - 1] = first;
            words[0] = last;
        }
        return String.join(" ", words);
    }
}
