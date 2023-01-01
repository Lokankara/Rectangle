//package main.java.com.ua.lab.homework.shape;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//import static java.lang.System.out;
//
//public class Exam {
//
//        public static void main(String[] args) {
//
//
//            long time = System.currentTimeMillis();
//
//            final String sentience_1 = "I originally approached Java as just another programming language. But as time\n" +
//                    "passed and I studied it more deeply. I began to see that the fundamental intent of\n" +
//                    "this language was different from other languages I had seen up to that point.\n" +
//                    "Programming is about managing complexity. The complexity of the problem you\n" +
//                    "want to solve. Laid upon the complexity of the machine in which it is solved.";
//
//            final String sentience_2 = "Because of this complexity most of our programming projects fail. And yet of all\n" +
//                    "the programming languages of which I am aware. Almost none have gone all out\n" +
//                    "and decided that their main design goal would be to conquer the complexity of\n" +
//                    "developing and maintaining programs. Many language design decisions were made\n" +
//                    "with complexity in mind. But at some point there were always other issues that\n" +
//                    "were considered essential to be added into the mix.";
//
//            String sentience = sentience_1 +sentience_2;
//
////        int size = words.length;
////
////        String[] first = Arrays.copyOfRange(words, 0, (size + 1) / 2);
////        String[] second = Arrays.copyOfRange(words, (size + 1) / 2, size);
////
////        List<String> min = new ArrayList<>();
////        Collections.addAll(min, first);
////
////        List<String> max = IntStream
////                .iterate(second.length - 1, index -> index >= 0, index -> index - 1)
////                .mapToObj(index -> second[index])
////                .collect(Collectors.toList());
////        out.printf("%d min words: %s%n", first.length, min);
////        out.printf("%d max words: %s%n", max.size(), max);
//
//            char space = ' ';
//            char dot = '.';
//            int slice = 0;
//            int length = 0;
//            int word = 0;
//            int wordCounter = 0;
//            int sentenceCounter = 0;
//            List<Integer> slicer = new ArrayList<>();
//            List<Integer> spaces = new ArrayList<>();
//            List<String> words = new ArrayList<>();
//
//            for (char letter : sentience.toCharArray()) {
//                length++;
//                word++;
//                if (space == letter) {
//                    spaces.add(length);
////                spaces.add(--word);
//                    wordCounter++;
//                    slice++;
//                    word = 0;
//                } else if (dot == letter) {
//                    sentenceCounter++;
//                    slicer.add(++slice);
//                    spaces.add(length);
//                    slice = 0;
////                spaces.add(--word);
//                }
//
//            }
//
////        int sum = sentenceCounter + wordCounter;
////        double average = sum / sentenceCounter;
////        out.println(String.format("Average: %s sum: %d", average, sum));
//
////        Collections.addAll(min, spaces);
//
//            time = System.currentTimeMillis() - time;
//            out.printf("Words: %s, length: %s, sentence:%s, time: %s, slicer: %s %n", wordCounter, length, sentenceCounter, time, slicer);
//            out.println(spaces);
//
//            int c = 0;
//            for (Integer integer : spaces) {
//                words.add(sentience.substring(c, integer).trim());
//                c = integer;
//            }
//
//            List<String> distinctElements = words.stream()
//                    .distinct()
//                    .collect(Collectors.toList());
//
////        Collections.sort(distinctElements, byLength);
//
//            out.println(words);
//
//            out.println(distinctElements);
//
//
////        String[] words = sentience.split(" ");
////        String[] sentence = sentience.split("\\.? ");
////        String[] sentences = sentience.split("\\. ");
//
////        Arrays.sort(words, Comparator.comparingInt(String::length));
////
////        int size = words.length;
////
////        String[] first = Arrays.copyOfRange(words, 0, (size + 1) / 2);
////        String[] second = Arrays.copyOfRange(words, (size + 1) / 2, size);
////
////        List<String> min = new ArrayList<>();
////        Collections.addAll(min, first);
////
////        List<String> max = IntStream
////                .iterate(second.length - 1, index -> index >= 0, index -> index - 1)
////                .mapToObj(index -> second[index])
////                .collect(Collectors.toList());
////        out.printf("%d min words: %s%n", first.length, min);
////        out.printf("%d max words: %s%n", max.size(), max);
//
//        for (char letter : sentience.toCharArray()) {
//            length++;
//            if (space == letter) {
//                spaces.add(length);
//                wordCounter++;
//                slice++;
//            } else if (dot == letter) {
//                sentenceCounter++;
//                slicer.add(slice);
//                slice = 0;
//            }
//        }
//
////        Collections.sort(words);
//
//        time = System.currentTimeMillis() - time;
//        out.printf("Words: %s, length: %s, sentence:%s, time: %s, slice: %s %n", wordCounter, length, sentenceCounter, time, slicer);
//        out.println(spaces);
//
//
//
////        words = sentience.split(" ");
////        Arrays.sort(words, Comparator.comparingInt(String::length));
//
//    }
//
//}
