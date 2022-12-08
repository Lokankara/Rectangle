package com.test.malaGupta;

import java.util.ArrayList;

class ChemistryBook extends Books {

//	public void read() {
//	return "Methods marked with //METHOD1 and //METHOD3 are correctly overloaded\r\n";
//	}

	public String read() {
		return "Methods marked with //METHOD1 and //METHOD2 are correctly overloaded\r\n";
	}

	ArrayList<?> read(int a) {
		return null;
	}
}

class Books {
	public String read() {
		return "ME Q#24, #28";
	};

	void myMethod(String str1, int str2, String str3) {
	};

	void myMethod(int str2, String str3, String str1) {
	};
}