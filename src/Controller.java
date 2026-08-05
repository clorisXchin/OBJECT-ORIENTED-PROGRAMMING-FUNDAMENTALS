
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private Scanner scanner;
    private ArrayList<Movie> movies;
    private ArrayList<Showtime> showtimes;
    private Customer currentCustomer;
    private int nextTicketNumber = 1;
    private int nextBookingNumber = 1;

    public Controller() {
        scanner = new Scanner(System.in);
        movies = new ArrayList<>();
        showtimes = new ArrayList<>();
        createCinemaData();

    }

    private void createCinemaData() {

        Movie movie1 = new Movie(
                "Avengers: Endgame",
                "Action",
                "English",
                
                181
        );

        Movie movie2 = new Movie(
                "The Conjuring",
                "Horror",
                "English",
                
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

            if (InputValidator.isValidName(name)) {
                return name.trim();
            }

            System.out.println(
                    "Name must contain 2 to 50 letters and spaces.");

        }
    }

    private int readInteger() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please enter number only: ");
            }
        }
    }

    private int readValidAge() {
        while (true) {
            System.out.print("Enter age: ");
            int age = readInteger();

            if (InputValidator.isValidAge(age)) {
                return age;
            }

            System.out.println("Age must be between 12 and 120.");
        }
    }

    private void registerCustomer() {
        System.out.println("\nWelcome to the Movie Ticketing System");

        String name = readValidName();
        int age = readValidAge();
        String email = readValidEmail();
        String phonenumber = readValidPhoneNumber();

        currentCustomer = new Customer(name, age, email, phonenumber);
         System.out.println("Registration successful!");
    }

    private String readValidPhoneNumber() {
        while (true) {
            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();

            if (InputValidator.isValidPhoneNumber(phoneNumber)) {
                return phoneNumber;
            }

            System.out.println(
                    "Phone number must start with 01 and contain 10 or 11 digits.");
        }
    }

    private String readValidEmail() {
        while (true) {
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            if (InputValidator.isValidEmail(email)) {
                return email;
            }

            System.out.println("Invalid email format.Please include '@' and a valid domain.");
        }
    }

    public void start() {
        registerCustomer();
        int choice;

        do {

            System.out.println("\n===== Movie Ticketing System =====");
            System.out.println("1. View Movies");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = readInteger();

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
                    viewBookings();
                    break;

                case 5:
                    System.out.println("\n=================================");
                    System.out.println("You have successfully exited the system.");
                    System.out.println("Thank you for using the Movie Ticketing System!");
                    System.out.println("=================================");
                    break;

                default:
                    System.out.println("Invalid choice!");

            }

        } while (choice != 5);

    }

    private void viewMovies() {
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
            System.out.println("Language: " + movie.getMovieLanguage());
            System.out.println("Duration: " + movie.getDurationMins() + " minutes");
        }

        System.out.println("\n===== AVAILABLE SHOWTIMES =====");

        for (int i = 0; i < showtimes.size(); i++) {
            Showtime showtime = showtimes.get(i);

            System.out.println("\nShowtime " + (i + 1));
            System.out.println("Movie: " + showtime.getMovie().getMovieTitle());
            System.out.println("Showtime ID: " + showtime.getShowtimeId());
            System.out.println("Date: " + showtime.getShowDate());
            System.out.println("Time: " + showtime.getTime());
            System.out.println("Hall: " + showtime.getHall().getHallId());
            System.out.println("Price: RM" + String.format("%.2f", showtime.getBasePrice()));
        }

    }

    private void bookTicket() {
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
        int showtimeChoice = readInteger();

        if (showtimeChoice < 1 || showtimeChoice > showtimes.size()) {
            System.out.println("Invalid showtime choice.");
            return;
        }

        Showtime selectedShowtime = showtimes.get(showtimeChoice - 1);
        Hall selectedHall = selectedShowtime.getHall();

        selectedHall.displaySeatPlan();
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

        int ticketChoice = readInteger();

        String ticketId = "T" + nextTicketNumber++;
        Ticket ticket;

        switch (ticketChoice) {
            case 1:
                ticket = new StandardTicket(ticketId, selectedSeat, selectedShowtime.getBasePrice());
                break;

            case 2:
                ticket = new PremiumTicket(ticketId, selectedSeat, selectedShowtime.getBasePrice());
                break;

            case 3:
                String studentId = readValidStudentId();
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

    private String readValidStudentId() {
        while (true) {
            System.out.print("Enter student ID: ");
            String studentId = scanner.nextLine();

            if (InputValidator.isValidStudentId(studentId)) {
                return studentId;
            }

            System.out.println(
                    "Student ID must contain 4 to 20 letters or digits.");
        }
    }

    private void cancelBooking() {
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

    private void viewBookings() {
        currentCustomer.viewHistory();
    }
}

