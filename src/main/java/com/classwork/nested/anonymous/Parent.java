package com.classwork.nested.anonymous;

interface Human {
};

interface Animal {
};

public class Parent implements Human, Animal {

	Human human = new Human() {
	};

	public void display() {
		System.out.println("Parent");
	}

	public static void main(String[] args) {

		Parent childParent = new Child();

		Child child = new Child();
		child.display();
//		child.g;

		Parent parent = new Parent() {
			int f = 80;

			void display(int f) {
			};

			@Override
			public void display() {
				System.out.println("anonymous singletone");
			};
		};

		parent.display();
		childParent.display();
	}
}

class Child extends Parent {
	int g = 100;

	@Override
	public void display() {
		System.out.println("Child");
	}
}
