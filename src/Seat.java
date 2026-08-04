
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

    // Return ID like "A1" or "B3" for user-friendly display
    public String getSeatId() {
        return String.valueOf(row) + column;
    }

    public boolean isBooked() {
        return isBooked;
    }

    // If successful, returns true if not returns false
    public boolean bookSeat() {
        if (!isBooked) {
            isBooked = true;
            return true;
        }
        return false;
    }

    // Show that the seat is now available again
    public void freeSeat() {
        this.isBooked = false;
    }
}
