package com.test.sierra.exam;

class OOthing {
	void doStuff() {
		System.out.print("oo ");
	}
}

class GuiThing extends OOthing {
	void doStuff() {
		System.out.print("gui ");
	}
}

public class Button extends GuiThing {
	void doStuff() {
		System.out.print("button ");
	}

	public static void main(String[] args) {
		new Button().go();
	}

	void go() {
		GuiThing g = new GuiThing();
		this.doStuff();
		super.doStuff();
//		 g.super.doStuff();
//		 super.g.doStuff();
//		 super.super.doStuff();
	}
}