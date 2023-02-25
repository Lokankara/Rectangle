package test.java.com.test.boyarsky.zoo;

public class Rodent {
	protected Integer chew() throws Exception {
		System.out.println("Rodent is chewing");
		return 1;
	}
}

class Beaver extends Rodent {
	public Integer chew() throws RuntimeException {
		System.out.println("Beaver is chewing on wood");
		return 2;
	}
}
