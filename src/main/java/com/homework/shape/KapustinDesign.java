package com.homework.shape;

public class KapustinDesign {
    public static double averageLength (String text) {
        int sentences = 0;
        int words = 0;

        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == ' ') {
                words++;
            } else if (text.charAt(i) == '.'){
                sentences++;
                words++;
                i++;
            }
        }

        return (double) words / sentences;
    }

    public static String concat (String a, String b){

        double averageText1 = averageLength(a);
        double averageText2 = averageLength(b);

        if (averageText1 > averageText2) {
            return firstTwoWords(a).concat(finalTwoWords(b));
        } else {
            return firstTwoWords(b).concat(finalTwoWords(a));
        }
    }

    private static String firstTwoWords (String text) {
        boolean findFirstWord = true;
        int i = 0;
        for (; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (findFirstWord) {
                    findFirstWord = false;
                } else {
                    break;
                }
            }
        }
        return text.substring(0,i);
    }

    private static String finalTwoWords (String text) {
        boolean findFirstWord = true;
        int i = text.length()-1;
        for (; i > -1; i--) {
            if (text.charAt(i) == ' ') {
                if (findFirstWord) {
                    findFirstWord = false;
                } else {
                    break;
                }
            }
        }
        return text.substring(i);
    }
}