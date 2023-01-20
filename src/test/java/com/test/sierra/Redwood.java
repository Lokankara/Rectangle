package com.test.sierra;

public class Redwood extends Tree {

	public static void main(String[] args) {
	new Redwood().go();
	}

	private void go() {
		go2(new Tree(), new Redwood() );
	}

	private void go2(Tree tree, Redwood redwood) {
		Redwood r2 = (Redwood) tree;
		Tree t2 = (Tree)redwood;
	}

}

class Tree {}
