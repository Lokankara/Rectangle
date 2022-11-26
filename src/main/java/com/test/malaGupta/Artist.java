package com.test.malaGupta;

class ColorPack {
 static int shadeCount = 12;
 static int getShadeCount() {
 return shadeCount;
 }
}
class Artist {
 public static void main(String args[]) {
 ColorPack pack1 = new ColorPack();
 
 System.out.print("#41 Compilation error: {static} int shadeCount ");
 
 System.out.println(pack1.getShadeCount());
 }
}