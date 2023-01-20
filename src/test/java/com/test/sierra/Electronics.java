package com.test.sierra;

public class Electronics implements Device {

	@Override
	public void doIt() {
	}
}

abstract class Phone1 extends Electronics {
}

interface Device {
	public void doIt();
}

abstract class Phone2 extends Electronics {
	public void doIt(int x) {
	};
}

abstract class Phone3 extends Electronics implements Device {
	public void doStuff() {
	};
}
