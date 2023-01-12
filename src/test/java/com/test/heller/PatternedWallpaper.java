package com.test.heller;

enum Wallpaper {
    BROWN, BLUE, YELLOW;
}

class PatternedWallpaper {

	public static void main(String[] args) {
    Wallpaper wallpaper = Wallpaper.BLUE;
//    Wallpaper wp =  new Wallpaper(Wallpaper.BLUE);
    
    int hc = Wallpaper.BLUE.hashCode();
    

	System.out.println(wallpaper);
	System.out.println(hc);
	}
    void aMethod(Wallpaper wp) {
    	System.out.println(wp);
    }
}
//enum PatternedWallpaper implements Wallpaper {
//	DOTS, PLAIN, STRIPES;
//}