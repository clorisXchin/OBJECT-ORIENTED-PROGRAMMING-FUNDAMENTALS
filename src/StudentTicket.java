/* StudentTicket applies a 20% discount when a valid student ID is provided. */
public class StudentTicket extends Ticket {
    private static final double DISCOUNT_RATE = 0.20;
    private String studentId;

    public StudentTicket(String ticketId, Seat seat, double basePrice, String studentId) {
        super(ticketId, seat, basePrice);

        if (!InputValidator.isValidStudentId(studentId)) {
            throw new IllegalArgumentException("Student ID must contain 4 to 20 letters or digits.");
        }  
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }
    @Override
    public double calculatePrice() {
        return getBasePrice() * (1 - DISCOUNT_RATE);
    }
    
    @Override
    public String getTicketType() {
        return "Student";
    }
}
