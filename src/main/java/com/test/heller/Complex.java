package com.test.heller;

 class Complex {
 private double real, imaginary;

         public Complex(double r, double i) {
         real = r; imaginary = i;
         }
 public Complex add(Complex c) {
         return new Complex(real + c.real,
                 imaginary + c.imaginary);
         }
 }

class Client {
void useThem() {
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(3, 4);
        Complex c3 = c1.add(c2);
//        double d = c3.real; // Illegal!
        }
}