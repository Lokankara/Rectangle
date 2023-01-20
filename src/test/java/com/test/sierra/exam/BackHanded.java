package com.test.sierra.exam;

public class BackHanded {
	int state = 0;

	BackHanded(int s) {
		state = s;
	}

	public static void main(String... hi) {
		BackHanded b1 = new BackHanded(1);
		BackHanded b2 = new BackHanded(2);
		System.out.println(b1.go(b1) + " " + b1.go(b2));
		 String s = ""; 
		  if(011 == 9) s += 4; 
		  if(0x11 == 17) s += 5; 
		  Integer I = 12345; 
		  if(I.intValue() == Integer.valueOf("12345")) s += 6; 
		 System.out.println(s);
	
	}

	int go(BackHanded b) {
		if (this.state == 2) {
			b.state = 5;
			go(this);
		}
		System.out.println(this.state);

		return ++this.state;
	}
}