public class Seat {
    private char row;
    private int column;
    private boolean isBooked;

    // Constructor
    public Seat(char row, int column) {
        this.row = row;
        this.column = column;
        this.isBooked = false; // By default, a real-world seat starts empty
    }

    // Logic: Combines char and int to create standard ID (e.g., "A1", "B4")
    public String getSeatId() {
        return String.valueOf(row) + column;
    }

    public boolean isBooked() {
        return isBooked;
    }

    // Logic: Returns true if successful, false if it was already taken
    public boolean bookSeat() {
        if (!isBooked) {
            isBooked = true;
            return true;
        }
        return false;
    }

    // Allows for cancellations/refunds
    public void freeSeat() {
        this.isBooked = false;
    }
}
