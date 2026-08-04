import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private Scanner scanner;
    private ArrayList<Movie> movies;
    private ArrayList<Showtime> showtimes;
    private Customer currentCustomer;
    private int nextBookingNumber = 1;

    public Controller() {
        scanner = new Scanner(System.in);
        movies = new ArrayList<>();
        showtimes = new ArrayList<>();
        createCinemaData();
        registerCustomer();
    }

        private void createCinemaData() {

        Movie movie1 = new Movie(
                "M001",
                "Avengers: Endgame",
                "Action",
                "English",
                "001",
                181
        );

        Movie movie2 = new Movie(
                "M002",
                "The Conjuring",
                "Horror",
                "English",
                "002",
                112
        );

        movies.add(movie1);
        movies.add(movie2);

        Hall hall1 = new Hall(
                "H001",
                3,
                5
        );

        Hall hall2 = new Hall(
                "H002",
                3,
                5
        );

        Showtime showtime1 = new Showtime(
                "S001",
                LocalDate.of(2026, 8, 10),
                "2:00 PM",
                movie1,
                hall1,
                15.00
        );

        Showtime showtime2 = new Showtime(
                "S002",
                LocalDate.of(2026, 8, 10),
                "8:00 PM",
                movie2,
                hall2,
                20.00
        );

        showtimes.add(showtime1);
        showtimes.add(showtime2);
    }

    private String readValidName() {
        while (true) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            try {
                if (!InputValidator.isValidName(name)) {
                throw new IllegalArgumentException("Name must contain only letters and spaces.");
            }
                return name;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int readValidAge() {
    while (true) {
        System.out.print("Enter age: ");

        try {
            int age = scanner.nextInt();
            scanner.nextLine();

            if (!InputValidator.isValidAge(age)) {
                throw new IllegalArgumentException("Age must be between 12 and 120.");
            }
                return age;
        } catch (Exception e) {
            System.out.println("Invalid age. Please enter a number between 12 and 120.");
            scanner.nextLine();
        }
    }
}
    private void registerCustomer() {
        System.out.println("\nWelcome to the Movie Ticketing System");

        String name = readValidName();
        int age = readValidAge();
        String email = readValidEmail();
        String phone_number = readValidPhoneNumber();
        String password = readValidPassword();

        currentCustomer = new Customer(name, age, email, password, phone_number);
}

private String readValidPhoneNumber() {
    while (true) {
        System.out.print("Enter phone number: ");
        String phone_number = scanner.nextLine();

        try {
            if (!InputValidator.isValidPhoneNumber(phone_number)) {
                throw new IllegalArgumentException("Phone number must start with 01 and contain 10 or 11 digits.");
            }

            return phone_number;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

private String readValidPassword() {
    while (true) {
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        try {
            if (!InputValidator.isValidPassword(password)) {
                throw new IllegalArgumentException("Password must have at least 8 characters, 1 uppercase letter, 1 lowercase letter, and 1 number.");
            }

            return password;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

private String readValidEmail() {
    while (true) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        try {
            if (!InputValidator.isValidEmail(email)) {
                throw new IllegalArgumentException("Invalid email format.");
            }

            return email;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

    public void start() {

        int choice;

        do {

              System.out.println("\n===== Movie Ticketing System =====");
              System.out.println("1. View Movies");
              System.out.println("2. Book Ticket");
              System.out.println("3. Cancel Booking");
              System.out.println("4. View Booking");
              System.out.println("5. Exit");
             System.out.print("Enter your choice: ");

        choice = scanner.nextInt();
        scanner.nextLine();

            switch (choice) {

                case 1:
                    viewMovies();
                    break;

                case 2:
                    bookTicket();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                   viewBooking();
                    break;

                case 5:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice!");

            }

        } while (choice != 5);

    }

    public void viewMovies() {
      System.out.println("\n===== AVAILABLE MOVIES =====");

    if (movies.isEmpty()) {
        System.out.println("No movies are currently available.");
        return;
    }

    for (int i = 0; i < movies.size(); i++) {
        Movie movie = movies.get(i);

        System.out.println("\nMovie " + (i + 1));
        System.out.println("Title: " + movie.getMovieTitle());
        System.out.println("Genre: " + movie.getMovieGenre());
        System.out.println("Duration: " + movie.getDurationMins() + " minutes");
    }

    System.out.println("\n===== AVAILABLE SHOWTIMES =====");

    for (int i = 0; i < showtimes.size(); i++) {
        Showtime showtime = showtimes.get(i);

        System.out.println("\nShowtime " + (i + 1));
        System.out.println("Movie: " + showtime.getMovie().getMovieTitle());
        System.out.println("Date: " + showtime.getShowDate());
        System.out.println("Time: " + showtime.getTime());
        System.out.println("Hall: " + showtime.getHall().getHallId());
        System.out.println("Price: RM" + showtime.getBasePrice()); 
       }
        
     }
    

    public void bookTicket() {
        if (showtimes.isEmpty()) {
            System.out.println("No showtimes are available for booking.");
        return;
        }

    System.out.println("\n===== BOOK TICKET =====");

    for (int i = 0; i < showtimes.size(); i++) {
        Showtime showtime = showtimes.get(i);

        System.out.println((i + 1) + ". "
                + showtime.getMovie().getMovieTitle()
                + " | " + showtime.getShowDate()
                + " | " + showtime.getTime()
                + " | Hall " + showtime.getHall().getHallId()
                + " | RM" + String.format("%.2f", showtime.getBasePrice()));
    }

    System.out.print("Choose showtime number: ");
    int showtimeChoice = scanner.nextInt();
    scanner.nextLine();

    if (showtimeChoice < 1 || showtimeChoice > showtimes.size()) {
        System.out.println("Invalid showtime choice.");
        return;
    }

    Showtime selectedShowtime = showtimes.get(showtimeChoice - 1);
    Hall selectedHall = selectedShowtime.getHall();

    selectedHall.displaySeatPlan();

    System.out.print("Enter seat ID, for example A1: ");
    String seatId = scanner.nextLine().trim().toUpperCase();

    Seat selectedSeat = null;
    
    while (true) {
	    System.out.print("Enter seat ID, for example A1: ");
	    String seatId = scanner.nextLine().trim().toUpperCase();
	
	    selectedSeat = selectedHall.getSeat(seatId);

    if (selectedSeat == null) {
        System.out.println("Invalid seat ID. Please try again.");
        continue; //ask for seat ID again
    }

    if (selectedSeat.isBooked()) {
        System.out.println("That seat is already booked.Please choose another seat.");
        continue; //ask for seat ID again
    }
    
    break; 
    }

    System.out.println("\nChoose ticket type:");
    System.out.println("1. Standard");
    System.out.println("2. Premium");
    System.out.println("3. Student");
    System.out.print("Enter your choice: ");

    int ticketChoice = scanner.nextInt();
    scanner.nextLine();

    String ticketId = "T" + nextBookingNumber++;
    Ticket ticket;

    switch (ticketChoice) {
        case 1:
            ticket = new StandardTicket(ticketId, selectedSeat, selectedShowtime.getBasePrice());
            break;

        case 2:
            ticket = new PremiumTicket(ticketId, selectedSeat, selectedShowtime.getBasePrice());
            break;

        case 3:
            System.out.print("Enter student ID: ");
            String studentId = scanner.nextLine();
            ticket = new StudentTicket(ticketId, selectedSeat, selectedShowtime.getBasePrice(), studentId);
            break;

        default:
            System.out.println("Invalid ticket type.");
            return;
    }

    String bookingId = "B" + nextBookingNumber++;

    Booking booking = new Booking(
            bookingId,
            currentCustomer,
            selectedShowtime,
            ticket
    );

    if (booking.confirmBooking()) {
        currentCustomer.addBooking(booking);
        System.out.println("Booking confirmed.");
        booking.displayReceipt();
    } else {
        System.out.println("Booking failed. The seat may already be booked.");
    }
    }

    public void cancelBooking() {
        System.out.println("\n===== CANCEL BOOKING =====");

    currentCustomer.viewHistory();
    System.out.print("Enter booking ID to cancel: ");
    String bookingId = scanner.nextLine().trim();

    Booking booking = currentCustomer.findBookingById(bookingId);

    if (booking == null) {
        System.out.println("Booking ID not found.");
        return;
    }

    if (booking.cancelBooking()) {
        System.out.println("Booking cancelled successfully.");
    } else {
        System.out.println("This booking cannot be cancelled.");
    }

    booking.displayReceipt();
        
    }

    public void viewBooking() {
        currentCustomer.viewHistory();
        }
    }

