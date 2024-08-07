package com.test.malaGupta;

class Whale {
    public static void main(String[] args) {
        boolean hungry = true;
        while (hungry) {
            ++Fish.count;
            hungry = Fish.isFeed();
            System.out.print(".");
        }
    }
}

class Fish {
    static byte count;

    public static boolean isFeed() {
        return count >= 0;
    }
}
