package com.classwork.threads.io.deadlock.test;

class FirstAndLastLetter {

	public static void main(String args[]) {
		String str = "azfo reek sza";
		System.out.println(str);
		System.out.println(change(str));
	}

	static String change(String line) {

		char[] ch = line.toLowerCase().toCharArray();
		for (int i = 0; i < ch.length; i++) {

			int k = i;
			while (i < ch.length && ch[i] != ' ')
				i++;

			ch[k] = transform(ch, k);
			ch[i - 1] = transform(ch, i - 1);

		}

		return new String(ch);
	}

	private static char transform(char[] ch, int k) {
		return (char) ((int) ch[k] >= 96 && (int) ch[k] <= 122 ? (int) ch[k] - 32 : (int) ch[k]);
	}

}