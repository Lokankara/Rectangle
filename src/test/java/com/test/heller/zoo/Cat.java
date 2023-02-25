package test.java.com.test.heller.zoo;

class Pet{
	boolean neutered;
	String markings;	
}
public class Cat extends Pet {
	
}
//E, F. The Cat class is a subclass of the Pet class, and as such should extend Pet, rather than contain an instance of Pet. B and C should be members of the Pet class and as such are inherited 
//into the Cat class; therefore, they should not be declared in the Cat class. D would declare a reference to an instance of the Cat class, which is not generally appropriate inside the Cat class 
//(unless, perhaps, you were asked to give the Cat a member that refers to its mother). Finally, the 
//neutered flag and markings descriptions, E and F, are the items Alerted for by the specification; 
//these are correct items.
//4. C. The class should be public, because it is to be used freely throughout the application. The 
//statement “A cat is a pet” tells you that the Cat class should subclass Pet. The other words 
//offered are required for the body of the definitions of either Cat or Pet—for use as member 
//variables—but are not part of the opening declaration.
//
//3. You have been given a design document for a veterinary registration system for implementation  in Java. It states:
//“A pet has an owner, a registration date, and a vaccination-due date. A cat is a pet that has a 
//flag indicating whether it has been neutered, and a textual description of its markings.”
//Given that the Pet class has already been defined, which of the following fields would be 
//appropriate for inclusion in the Cat class as members? (Choose all that apply.)
//A. Pet thePet;
//B. Date registered;
//C. Date vaccinationDue;
//D. Cat theCat;
//E. boolean neutered;
//F. String markings;

//4. You have been given a design document for a veterinary registration system for implementation 
//“A pet has an owner, a registration date, and a vaccination-due date. A cat is a pet that has a 
//flag indicating if it has been neutered, and a textual description of its markings.”
//Given that the Pet class has already been defined and you expect the Cat class to be used freely 
//throughout the application, how would you make the opening declaration of the Cat class, up 
//to but not including the first opening brace? Use only these words and spaces: boolean, Cat, 
//class, Date, extends, Object, Owner, Pet, private, protected, public, String.
//A. protected class Cat extends Owner
//B. public class Cat extends Object
//C. public class Cat extends Pet
//D. private class Cat extends Pet
