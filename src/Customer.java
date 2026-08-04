import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

	private List<Booking> bookingHistory;
	
	public Customer () {
		super();
		this.bookingHistory = new ArrayList<>();
	}
	
	public Customer(String name, int age, String email, String password, String phone_number) {
		super(name, age, email, password, phone_number);
		this.bookingHistory = new  ArrayList<>();
	}
	
	public void addBooking(Booking booking) {
        this.bookingHistory.add(booking);
	}
        
	public void viewHistory() {
		System.out.println("\n--- Booking History for " + getName() + " ---");
		if (bookingHistory.isEmpty())
			System.out.println("No booking history found.");
		else {
			for(Booking booking: bookingHistory) {
				booking.displayReceipt();
			}
		}
	}
	
	public Booking findBookingById(String bookingId) {
    	for (Booking booking : bookingHistory) {
        	if (booking.getBookingId().equalsIgnoreCase(bookingId)) {
            	return booking;
        	}
    }
   		 return null;
	}
	@Override
	public void displayMenu() {
	        System.out.println("\n==============================");
	        System.out.println("   CINEMA TICKETING SYSTEM");
	        System.out.println("==============================");
	        System.out.println("1. View Movies");
	        System.out.println("2. Book Ticket");
	        System.out.println("3. Cancel Booking");
	        System.out.println("4. View Booking");
	        System.out.println("5. Exit");
	        System.out.println("==============================");
	        System.out.print("Enter your choice: ");

	    
		
	}
}
