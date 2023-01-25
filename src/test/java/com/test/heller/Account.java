package com.test.heller;

import java.io.*;

public class Account implements Externalizable {
	private String ownerName;
	private String password;
	private float balance;

	private String reverse(String reverseMe) {
		String reversed = "";
		for (int i = reverseMe.length() - 1; i >= 0; i--)
			reversed += reverseMe.charAt(i);
		return reversed;
	}

	public void writeExternal(ObjectOutput outStream) throws IOException {
		outStream.writeObject(ownerName);
		outStream.writeObject(reverse(password));
		outStream.writeObject(new Float(balance));
	}

	public void readExternal(ObjectInput inStream) throws IOException, ClassNotFoundException {
		ownerName = (String) inStream.readObject();
		String reversedPassword = (String) inStream.readObject();
		password = reverse(reversedPassword);
		balance = ((Float) inStream.readObject()).floatValue();
	}
}