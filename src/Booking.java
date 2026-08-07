//Calculates the ticket price using polymorphic ticket rules
// and applies seat and payment logic."
public class Booking {

    private static final double BOOKING_FEE = 1.50;
    private static final String PENDING = "PENDING";
    private static final String CONFIRMED = "CONFIRMED";
    private static final String CANCELLED = "CANCELLED";

    private String bookingId;
    private Customer customer;
    private Showtime showtime;
    private Ticket ticket;
    private String status;

    public Booking(String bookingId, Customer customer, Showtime showtime, Ticket ticket) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.showtime = showtime;
        this.ticket = ticket;
        status = PENDING;
    }

    public String getBookingId() {
        return bookingId;
    }

    public boolean confirmBooking() {
        if (status.equals(PENDING) && ticket.getSeat().bookSeat()) {
            status = CONFIRMED;
            return true;
        }
        return false;
    }

    public double getTicketPrice() {
        return ticket.calculatePrice();
    }

    // Formula: final total = polymorphic ticket price + fixed booking fee.
    public double calculateTotal() {
        return getTicketPrice() + BOOKING_FEE;
    }

    //Cancel the booking and free the seat
    public boolean cancelBooking() {
        if (status.equals(CONFIRMED)) {
            ticket.getSeat().freeSeat();
            status = CANCELLED;
            return true;
        }
        return false;
    }

    // Prints receipt
    public void displayReceipt() {
        System.out.println("\n----------------------------------------");
        System.out.println("Booking ID : " + bookingId);
        System.out.println("Customer   : " + customer.getName());
        System.out.println("Phone      : " + customer.getPhonenumber());
        System.out.println("Movie      : " + showtime.getMovie().getMovieTitle());
        System.out.println("Showtime   : " + showtime.getShowDate() + " " + showtime.getTime());
        System.out.println("Hall/Seat  : " + showtime.getHall().getHallId()
                + " / " + ticket.getSeat().getSeatId());
        System.out.println("Ticket ID  : " + ticket.getTicketId());
        System.out.println("Ticket     : " + ticket.getTicketType());
        System.out.println("Ticket fee : RM" + String.format("%.2f", getTicketPrice()));
        System.out.println("Booking fee: RM" + String.format("%.2f", BOOKING_FEE));
        System.out.println("Total      : RM" + String.format("%.2f", calculateTotal()));
        System.out.println("Status     : " + status);
        System.out.println("----------------------------------------");
    }
}
