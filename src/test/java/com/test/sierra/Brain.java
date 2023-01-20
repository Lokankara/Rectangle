package com.test.sierra;

import java.util.*;

class Brain {
	public static void main(String[] args) {
		Scanner scd = new Scanner("123 A 3b c,45, x5x,76 82 L").useDelimiter(" ");
		while (scd.hasNext()) {
			if (scd.hasNextInt())
				System.out.print(scd.nextInt() + " ");
			else
				scd.next();
		}

//		Scanner sca = new Scanner("123 A 3b c,45, x5x,76 82 L");
//		 while(sca.hasNextInt()) System.out.print(sca.nextInt() + " ");
//		
//		 Scanner scb = new Scanner("123 A 3b c,45, x5x,76 82 L").useDelimiter(" ");
//		 while(scb.hasNextInt()) System.out.print(scb.nextInt() + " ");

		Scanner scc = new Scanner("123 A 3b c,45, x5x,76 82 L");
		while (scc.hasNext()) {
			if (scc.hasNextInt())
				System.out.print(scc.nextInt() + " ");
			else
				scc.next();
		}

		Scanner sce = new Scanner("123 A 3b c,45, x5x,76 82 L");
		do {
			if (sce.hasNextInt())
				System.out.print(sce.nextInt() + " ");
		} while (sce.hasNext());

		Scanner sc = new Scanner("123 A 3b c,45, x5x,76 82 L").useDelimiter(" ");
		do {
			if (sc.hasNextInt())
				System.out.print(sc.nextInt() + " ");
		} while (sc.hasNext());
	}
}
