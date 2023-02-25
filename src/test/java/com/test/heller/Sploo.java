package test.java.com.test.heller;

// B, D, F. A static import does not apply to non-static features, so A, C, and E are ruled out. Since 
//the class performing the import is in the same package as Sploo, all static features (data and 
//methods) that have public, protected, or default access are imported into the importing class namespace.

class Sploo {
 public int a;
 public static int b;
 int c;
 static int d;
 public void eee() { }
 public static void fff() { }
}