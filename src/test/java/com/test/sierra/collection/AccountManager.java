package com.test.sierra.collection;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
	private Map<String, Integer> accountTotals = new HashMap<String, Integer>();
	private int retirementFund;

	public int getBalance(String accountName) {

		return accountTotals.get(accountName) == null 
				? 0 : accountTotals.get(accountName);
	}

	public void setBalance(String accountName, int amount) {
		accountTotals.put(accountName, amount);
	}

	public static void main(String[] args) {
		AccountManager manager = new AccountManager();
		manager.getBalance("name");
	}

}
