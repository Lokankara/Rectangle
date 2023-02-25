package main.java.com.homework.stream;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LazyEager {
    public static void main(String[] args) {

        List<Integer> numbers = IntStream.range(0, 10).mapToObj(i -> ThreadLocalRandom.current().nextInt(-100, 101)).toList();

        List<Integer> pos = numbers.stream().filter(num -> num > 0).toList();
        List<Integer> neg = numbers.stream().filter(num -> num < 0).toList();

        Map<Boolean, List<Integer>> result = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n >= 0));


//        Map<Boolean, List<Integer>> teeing = IntStream.range(0, 10)
//                .mapToObj(i -> ThreadLocalRandom.current().nextInt(-100, 101)).toList()
//                .stream().collect(Collectors.teeing(
//                        Collectors.filtering(n -> n < 0, Collectors.toList()),
//                        Collectors.filtering(n -> n > 0, Collectors.toList()),
//                        (negative, positive) -> Map.of(false, negative, true, positive)));

        Map<Boolean, List<Integer>> number =
                ThreadLocalRandom.current()
                .ints(-100, 101)
                .limit(10)
                .boxed()
                .collect(Collectors.groupingByConcurrent(n -> n >= 0));


        System.out.println("Positive numbers: " + number.get(true));
        System.err.println("Negative numbers: " + number.get(false));

        System.out.println("Positive numbers: " + result.get(true));
        System.err.println("Negative numbers: " + result.get(false));

        System.out.println(pos);
        System.err.println(neg);

//
//        list.forEach(integer -> {
//            if (integer >= 0) {
//                pos.add(integer);
//            } else {
//                neg.add(integer);
//            }
//        });
//
//        IntStream seq = IntStream.of(list).filter(i -> i!=0);
//        List<List<Integer>> result =
//                IntStreamEx.of(seq).boxed().groupRuns((i1, i2) -> Math.signum(i1) == Math.signum(i2)).toList();

//        System.out.println(sortBest("is2 sentence4 This1 a3"));

        String sentences = "" + "You must have a cup of tea. "
                + "If you don't think, you shouldn't talk. "
                + "I have an excellent idea. "
                + "Let's change the subject. "
                + "Ah, but it's very rude to sit down without being invited. "
                + "Careful, she's stark raving mad. "
                + "I shall elucidate. "
                + "Twinkle twinkle little bat. "
                + "How I wonder what you're at. "
                + "Up and above the world you fly, like a tea tray in the sky. "
                + "You can always take more than nothing. "
                + "Why is a raven like a writing desk.";

        long start01 = System.nanoTime();
        String stringStream = Arrays.stream(sentences.split(" "))
                .map(s -> Pattern.compile("\\b(?=\\p{Ll})\\b").splitAsStream(s)
                        .map(word -> "%s%s".formatted(
                                Character.toUpperCase(word.charAt(0)),
                                word.substring(1)))
                        .collect(Collectors.joining())).collect(Collectors.joining(" "));
        long end01 = System.nanoTime();

        System.out.println(stringStream);
        System.out.println((end01 - start01));


//        long start2 = System.nanoTime();
//        TreeSet<String> tree = new TreeSet<>(Comparator.comparing(s -> s.split(" ")[0]));
//        char[] chars = sentences.toCharArray();
//        for (int i = 0, p = 0; i < chars.length; i++) {
//            if (chars[i] == '.') {
//                tree.add(sentences.substring(p, i + 1));
//                p = i + 2;
//            }
//        }

//        long end2 = System.nanoTime();


//        sortedSentences.forEach(System.out::println);

//        for (int n = 0; n < letters.length; n++) {
//        sentences.findAll(" ").count();

        List<String> sentenceList = Pattern.compile("(?<=[.])\\s+")
                .splitAsStream(sentences)
                .sorted(Comparator.comparingInt(sentence -> sentence.split("\\s+").length))
                .toList();

        sentenceList.forEach(System.out::println);


        String capitalize = Pattern.compile("\\b(?=\\p{Ll})\\b").splitAsStream(sentences).map(word -> "%s%s"
                .formatted(Character.toUpperCase(word.charAt(0)), word.substring(1))).collect(Collectors.joining());


        //        result.forEach(System.out::println);
//line
//        String collect = Arrays.stream(line.split("\\s+"))
//                .map(t -> "%s%s".formatted(t.substring(0, 1).toUpperCase(), t.substring(1).toLowerCase())).toString();
//
//
//        System.err.println(collect);
    }

    private static void println(Object data) {
        System.out.println(data);
    }

    private static <T> void print(Collection<T> list) {
        list.forEach(LazyEager::println);
    }

    private static char changeLowerCase(char[] letters, int n) {
        if (letters.length == 1) {
            return letters[0];
        } else {
            if (letters[n] >= 96 && letters[n] <= 122) return (char) (letters[n] - 32);
            return (char) letters[n];
        }
    }

    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        return IntStream.rangeClosed(1, words.length)
                .mapToObj(i -> "%s ".formatted(Arrays.stream(words)
                        .collect(Collectors.toMap(word -> word.charAt(word.length() - 1) - '0',
                                word -> word.substring(0, word.length() - 1), (a, b) -> b))
                        .get(i))).collect(Collectors.joining()).trim();
    }

    public static String sortBest(String s) {
        String[] words = s.split(" ");
        String[] ans = new String[words.length];
        Arrays.stream(words).forEach(w -> ans[w.charAt(w.length() - 1) - '1'] = w.substring(0, w.length() - 1));
        return String.join(" ", ans);
    }

    public static String sorted(String s) {

        String[] words = s.split(" ");
        String[] originalWords = new String[words.length];

        Arrays.stream(words).forEach(word -> originalWords[Integer.parseInt(word.substring(word.length() - 1)) - 1] = word.substring(0, word.length() - 1));

        StringBuilder sb = new StringBuilder();
        Arrays.stream(originalWords).forEach(word -> sb.append(word).append(" "));
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }
}