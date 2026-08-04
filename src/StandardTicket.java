/* StandardTicket charges the showtime's full base price. */
public class StandardTicket extends Ticket {
    public StandardTicket(String ticketId, Seat seat, double basePrice) {
        super(ticketId, seat, basePrice);
    }
    // Overrides the superclass method: standard price = 100% of base price.
    @Override
    public double calculatePrice() {
        return getBasePrice();
    }
    // Supplies the type printed on the booking receipt.
    @Override
    public String getTicketType() {
        return "Standard";
    }
}
