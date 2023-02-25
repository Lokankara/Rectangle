/**
 * 
 */
package test.java.com.test.boyarsky.zoo.aquarium;

/**
 * @author PPoliak
 *
 */
public class ClownFish implements Aquatic {
	public String getNumberOfGills() {
		return "4";
	}
	@Override
	public int getNumberOfGills(int input) {
		return 6;
	}

	public static void main(String[] args) {
	  System.out.println(new ClownFish().getNumberOfGills(-1));
	  System.out.println("Multiple markers at this line\r\n"
	  		+ "	- The return type is incompatible with Aquatic.getNumberOfGills(int)\r\n");
	}
}
