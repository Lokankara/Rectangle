package test.java.com.test.boyarsky;

import java.util.ArrayList;
import java.util.List;

interface CanSwim {}
class Amphibian implements CanSwim {}
class Tadpole extends Amphibian {}
public class FindAll{ 
 public static void main(String[] args) { 
 List<Tadpole> tadpoles = new ArrayList<Tadpole>(); 
 for(Amphibian amphibian : tadpoles) { 
	 Object tadpole = amphibian;
		System.out.print("swing " + tadpole.getClass());

} } }