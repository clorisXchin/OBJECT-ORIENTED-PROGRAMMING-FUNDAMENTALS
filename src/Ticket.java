//Ticket is the general superclass for all ticket types.

public class Ticket {

    private String ticketId;
    private Seat seat;
    private double basePrice;

    public Ticket(String ticketId, Seat seat, double basePrice) {
        this.ticketId = ticketId;
        this.seat = seat;
        setBasePrice(basePrice);
    }

    public String getTicketId() {
        return ticketId;
    }

    public Seat getSeat() {
        return seat;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Base price must be more than RM0.00.");
        }
        this.basePrice = basePrice;
    }

    public double calculatePrice() {
        return getBasePrice();
    }

    public String getTicketType() {
        return "General";
    }
}
