package com.test.heller;

public class Heller {
	
	final void last() {
		
	}
	
    public static void main(String[] args) {

        //TODO#1 Review Questions
        System.out.println("#1 Review");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                System.out.println("i=" + i + " j=" + j);
            }
        }

        //TODO#2 Review Questions.
        System.out.println("#2 Review");
        outer:
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue outer;
                }
                System.out.println("i=" + i + " j=" + j);
            }
        }
        //TODO#5 Review Questions.
        System.out.println("The output would be the text value is two followed by the text value is three.");
        int j = 2;
        switch (j) {
            case 2:
                System.out.println("value is two");
            case 2 + 1:
                System.out.println("value is three");
                break;
            default:
                System.out.println("value is " + j);
                break;
        }

        //TODO#4 Review Questions.
        int x = 0, y = 4, z = 5;
        if (x > 2) {
            if (y < 5) {
                System.out.println("message one");
            }
            else {
                System.out.println("message two");
            }
        }
        else if (z > 5) {
            System.out.println("message three");
        }
        else {
            System.out.println("message four");
        }


        Wallpaper wp = Wallpaper.BLUE;
//        Wallpaper wp = new Wallpaper(Wallpaper.BLUE);

//        void aMethod(Wallpaper wp) {
//            System.out.println(wp);
//        }
        int hashCode = Wallpaper.BLUE.hashCode();
    }
}
