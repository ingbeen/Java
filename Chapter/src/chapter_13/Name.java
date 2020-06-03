package chapter_13;

public class Name {
	String firstName;
	String lastName;
	
	public Name(String firestName, String lastName) {
		this.firstName = firestName;
		this.lastName = lastName;
	}
	
	@Override
	public int hashCode() {
		return firstName.hashCode() + lastName.hashCode();
	}
	
	@Override
	public  boolean equals(Object obj) {
		if(!(obj instanceof Name)) {
			return false;
		}
		Name name = (Name) obj;
		if(firstName.equals(name.firstName) && lastName.equals(name.lastName)) {
			return true;
		} else {
			return false;
		}
	}
}
