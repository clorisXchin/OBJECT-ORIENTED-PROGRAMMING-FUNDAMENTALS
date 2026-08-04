public class Hall {
    private String hallId;
    private Seat[][] seats;
    private int totalRows;
    private int totalColumns;

    // Constructor
    public Hall(String hallId, int totalRows, int totalColumns) {
        this.hallId = hallId;
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.seats = new Seat[totalRows][totalColumns];
        initializeSeats();
    }

    // Logic: Automates the creation of the 2D grid of Seat objects
    private void initializeSeats() {
        for (int i = 0; i < totalRows; i++) {
            char rowChar = (char) ('A' + i); // Converts 0 to 'A', 1 to 'B', etc.
            for (int j = 0; j < totalColumns; j++) {
                seats[i][j] = new Seat(rowChar, j + 1); // Columns usually start at 1
            }
        }
    }

    // Logic: Translates a String ID (like "B3") back into array indices [1][2]
    public Seat getSeat(String seatId) {
        if (seatId == null || seatId.length() < 2) return null;
        
        char rowChar = Character.toUpperCase(seatId.charAt(0));
        int rowIndex = rowChar - 'A';
        
        try {
            int colIndex = Integer.parseInt(seatId.substring(1)) - 1;
            
            // Boundary validation to prevent ArrayOutOfBounds crashes
            if (rowIndex >= 0 && rowIndex < totalRows && colIndex >= 0 && colIndex < totalColumns) {
                return seats[rowIndex][colIndex];
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid seat format.");
        }
        return null;
    }

    // Real-world application: Visualizes the room for the user to make a choice
    public void displaySeatPlan() {
        System.out.println("--- Screen for Hall " + hallId + " ---");
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                String status = seats[i][j].isBooked() ? "[X]" : "[O]";
                System.out.print(seats[i][j].getSeatId() + status + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    // Controller interaction: attempts to book through the Hall facade
    public boolean bookSeat(String seatId) {
        Seat targetSeat = getSeat(seatId);
        if (targetSeat != null) {
            boolean success = targetSeat.bookSeat();
            if (success) {
                System.out.println("Success: " + seatId + " has been booked.");
                return true;
            } else {
                System.out.println("Error: " + seatId + " is already occupied.");
                return false;
            }
        }
        System.out.println("Error: " + seatId + " does not exist in this hall.");
        return false;
    }
    public String getHallId() {
        return hallId;
    }
}
