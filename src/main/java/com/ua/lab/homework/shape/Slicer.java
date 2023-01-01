//package main.java.com.ua.lab.homework.shape;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static java.lang.System.out;
//
//public class Slicer {
//
//    public static double average(List<Integer> array) {
//        int sum = array.stream().mapToInt(j -> j).sum();
//        return (double) sum / array.size();
//    }
//
//    public static void concat(String a, String b) {
//
//       String sentience = "I originally approached Java as just another programming language";
//
//       long time = System.currentTimeMillis();
//
//       char space = ' ';
//       char dot = '.';
//       int slice = 0;
//       int length = 0;
//       int wordCounter = 0;
//       int sentenceCounter = 0;
//       List<Integer> slicer = new ArrayList<>();
//       List<Integer> spaces = new ArrayList<>();
//       List<String> words = new ArrayList<>();
//
//       for (char letter : sentience.toCharArray()) {
//           length++;
//           if (space == letter) {
//               spaces.add(length);
//               wordCounter++;
//               slice++;
//           } else if (dot == letter) {
//               sentenceCounter++;
//               slicer.add(slice);
//               slice = 0;
//           }
//       }
//
////        Collections.sort(words);
//
//       time = System.currentTimeMillis() - time;
//       out.printf("Words: %s, length: %s, sentence:%s, time: %s, slice: %s %n", wordCounter, length, sentenceCounter, time, slicer);
//       out.println(spaces);
//
//    }
//}
