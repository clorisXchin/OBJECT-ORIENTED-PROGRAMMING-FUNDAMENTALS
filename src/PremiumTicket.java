//Add 50%for premium ticket
public class PremiumTicket extends Ticket {
    private static final double PREMIUM_RATE = 0.50;
    public PremiumTicket(String ticketId, Seat seat, double basePrice) {
        super(ticketId, seat, basePrice);
    }
    @Override
    public double calculatePrice() {
        return getBasePrice() * (1 + PREMIUM_RATE);
    }
    
    @Override
    public String getTicketType() {
        return "Premium";
    }
}
