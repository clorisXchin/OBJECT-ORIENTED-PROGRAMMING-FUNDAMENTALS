import java.util.Scanner;

public class controller {

    Scanner sc = new Scanner(System.in);
    menu menu = new menu();

    public void start() {

        int choice;

        do {

            menu.displayMenu();
            choice = sc.nextInt();

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
        System.out.println("Displaying movie list...");
        // Call Movie class later
    }

    public void bookTicket() {
        System.out.println("Booking ticket...");
        // Call Booking class later
    }

    public void cancelBooking() {
        System.out.println("Cancelling booking...");
        // Call Booking class later
    }

    public void viewBooking() {
        System.out.println("Displaying booking details...");
        // Call Booking class later
    }

}