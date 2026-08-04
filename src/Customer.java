import java.util.ArrayList;

public class Customer extends User {
    private ArrayList<Booking> bookingHistory;

    public Customer(String name, int age, String email, String phonenumber) {
        super(name, age, email, phonenumber);
        this.bookingHistory = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        this.bookingHistory.add(booking);
    }

    public void viewHistory() {
        System.out.println("\n--- Booking History for " + getName() + " ---");
        if (bookingHistory.isEmpty()) {
            System.out.println("No booking history found."); 
        }else {
            for (Booking booking : bookingHistory) {
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
}
