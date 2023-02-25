//package com.shape;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//import static java.lang.System.out;
//
//public class StringApi {
//
//    static String str = ""
//            + "1)Зробити великими перші букви у кожному слові тексту. "
//            + "2)В тексті слова заданої довжини ізаміниті вказаним підрядком довільної довжини. "
//            + "3)Після кожного слова тексту, що закінчується заданим підрядком, вставити " + "вказане слово. "
//            + "4)В тексті до кожного слова з довжиною, більшою за k символів, вставити заданий " + "підрядок після k-го символу. "
//            + "5)Утворити колекцію зі слів тексту, в яких перша і остання букви співпадають. "
//            + "6)Утворити дві колекції зі слів тексту максимальної та слів мінімальної довжини. "
//            + "7)В кожному реченні тексту поміняти місцями перше слово з останнім "
//            + "(припускаємо, що всі речення закінчуються тільки крапкою).";
//
//    public static void main(String[] args) {
//
//        int k = 5;
//        int length = 5;
//        String word = "речі";
//        String syllable = "і";
//        String insert = "реченні";
//        String part = "слово не горобець";
//        String[] words = str.split(" ");
//        String[] sentence = str.split("\\.? ");
//        String[] sentences = str.split("\\. ");
//
//        task1(words);
//
//        task2(words, length, insert);
//
//        task3(words, syllable, word);
//
//        task4(words, k, part);
//
//        task5(sentence);
//
//        task6(words);
//
//        task7(sentences);
//    }
//
//    private static void task2(String[] words, int length, String insert) {
//        out.println("task2# In the text, words of the given length are replaced by the specified substring of arbitrary length.");
//        List<String> newWords = new ArrayList<>();
//        for (String word : words) {
//            String s = word.length() == length ? insert : word;
//            newWords.add(s);
//        }
//        out.println(newWords);
//    }
//
//    private static void task3(String[] words, String syllable, String insert) {
//        out.println("task3# After each word of the text that ends with the specified substring, insert the specified word.");
//        String replace = String
//                .join(" ", words)
//                .replace(
//                        String.format("%s ", syllable),
//                        String.format("%s %s ", syllable, insert));
//        out.println(replace);
//    }
//
//    private static void task6(String[] words) {
//        out.println("task#6 Create two collections of text words of maximum length and words of minimum length");
//
//        Arrays.sort(words, Comparator.comparingInt(String::length));
//
//        int size = words.length;
//
//        String[] first = Arrays.copyOfRange(words, 0, (size + 1) / 2);
//        String[] second = Arrays.copyOfRange(words, (size + 1) / 2, size);
//
//        List<String> min = new ArrayList<>();
//        Collections.addAll(min, first);
//
//        List<String> max = IntStream
//                .iterate(second.length - 1, index -> index >= 0, index -> index - 1)
//                .mapToObj(index -> second[index])
//                .collect(Collectors.toList());
//        out.printf("%d min words: %s%n", first.length, min);
//        out.printf("%d max words: %s%n", max.size(), max);
//
//    }
//
//    private static void task4(String[] words, int k, String insert) {
//        out.println("task#4 In the text, for each word with a length greater than k chars, " +
//                "insert the specified substring after the k char.");
//
//        List<String> newWords = Arrays
//                .stream(words)
//                .map(word -> word.length() > k ? String.format("%s ", insert) : word)
//                .collect(Collectors.toList());
//        out.println(newWords);
//    }
//
//    private static void task5(String[] words) {
//        out.println("task#5 Create a collection of text words in which the first and last letters match ");
//
//        Set<String> set =
//                Arrays
//                .stream(words)
//                .filter(word ->
//                        word.toCharArray()[0]
//                                == word.toCharArray()[word.toCharArray().length - 1]
//                                && word.toCharArray().length - 1 > 1)
//                .collect(Collectors.toSet());
//        out.println(set);
//    }
//
//    private static void task1(String[] words) {
//        out.println("task#1 Capitalize the first letters in each word of the text");
//        String join = String.join(" ",
//                Arrays.stream(words)
//                        .map(word -> String.format("%s%s",
//                                word.substring(0, 1).toUpperCase(),
//                                word.substring(1)))
//                        .toArray(String[]::new));
//        out.println(join);
//    }
//
//    private static void task7(String[] sentences) {
//        out.println("task#7 In each sentence of the text, swap the first word with the last");
//        Arrays.stream(sentences).forEach(StringApi::change);
//    }
//
//    private static void change(String sentence) {
//        String[] words = sentence.split(" ");
//        String last = words[words.length - 1];
//        String first = words[0];
//        words[words.length - 1] = first;
//        words[0] = last;
//        Arrays.stream(words).forEach(word -> out.printf("%s ", word));
//    }
//
//    public static class IntegerComparator implements Comparator<Integer> {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return o2.compareTo(o1);
//        }
//    }
//}
