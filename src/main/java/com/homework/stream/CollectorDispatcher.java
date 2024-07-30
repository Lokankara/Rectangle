package com.homework.stream;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectorDispatcher {

    private static String sentences = "You must have a cup of tea. "
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
//        {1=0, 2=9, 3=0, 4=8, 5=10, 6=9, 7=1, 8=9, 9=3, 10=10, 11=7, 12=7}

    private static Pattern vowel = Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE);
    private static Pattern consonants = Pattern.compile("[zxcvbnmsdfghjklqwrtyp]", Pattern.CASE_INSENSITIVE);
    private static Matcher matcherSentence = Pattern.compile("[^.!?]+[.!?]+(\\s|$)").matcher(sentences);

    private static Matcher matcherVowel;
    private static Matcher matcherConsonants;

    private static Map<Integer, Integer> map = new ConcurrentHashMap<>();
    private static AtomicInteger s = new AtomicInteger(0);
    private static AtomicInteger difference = new AtomicInteger(0);


    public static void main(String[] args) {

        matcherSentence.results()
                .sequential()
                .parallel()
                .map(MatchResult::group)
                .map(sentence -> {
                            sentence.toLowerCase().chars().parallel()
                                    .filter(c -> c == 33 || c == 46 || c == 63 || c > 95 && c < 123)
                                    .forEach(c -> {
                                        if (c == 33 || c == 46 || c == 63) {
                                            s.incrementAndGet();
                                            difference.getAndSet(0);
                                        } else {
                                            difference.set(c == 97 || c == 101 || c == 105 || c == 111 || c == 117 ? difference.decrementAndGet()
                                                    : difference.incrementAndGet());
                                        }
                                    });
                            return difference;
                        }
                )
                .forEach(c -> map.put(s.get(), difference.getAndSet(0)));

        System.out.println(map);

//        counterMatcher();
    }

    private static void counterMatcher() {
        while (matcherSentence.find()) {
            matcherVowel = vowel.matcher(matcherSentence.group());
            matcherConsonants = consonants.matcher(matcherSentence.group());

            while (matcherVowel.find()) {
                difference.decrementAndGet();
            }
            while (matcherConsonants.find()) {
                difference.incrementAndGet();
            }
            map.put(s.incrementAndGet(), difference.getAndSet(0));
        }
        System.out.println(map);
    }

    private static int calculate(String sentence) {
        AtomicInteger count = new AtomicInteger(0);
        String lowerCaseSentence = sentence.toLowerCase();
        for (int i = 0; i < sentence.length(); i++) {
            char ch = lowerCaseSentence.charAt(i);
            if (ch > 95 && ch < 123) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count.decrementAndGet();
                } else {
                    count.decrementAndGet();
                }
            }
        }
        return count.get();
    }
}
