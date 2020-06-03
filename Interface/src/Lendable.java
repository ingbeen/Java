
public interface Lendable {
	void checkOut(String borrower, String date);  
	abstract void checkIn();
}
