package com.test.heller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DoItMyself implements Serializable {
	private String id;
	protected int n;
	transient byte notMe;

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeUTF("The password is swordfish");
		oos.defaultWriteObject();
	}

	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		String password = ois.readUTF();
		if (!password.equals("The password is swordfish"))
			throw new SecurityException("Bad password");
		ois.defaultReadObject();
	}
}
