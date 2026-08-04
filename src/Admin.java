
public class Admin extends User {

	public Admin(String name, int age, String email, String password, String phone_number) {
		super(name, age, email, password, phone_number);
	}
	
	public void addMovie(String Title) {
		System.out.println("[Admin" + getName() + "] added movie " + Title);
	}
	
	public void scheduleShowtime(String Title, String time) {
		System.out.println("[Admin" + getName() + "] schedule movie " + Title + "at"
				+ time);
	}
	
	@Override
	public void displayMenu() {
		 System.out.println("\n==============================");
	        System.out.println("   CINEMA TICKETING SYSTEM");
	        System.out.println("==============================");
	        System.out.println("1. Add Movies");
	        System.out.println("2. Schedule Showtime");
	        System.out.println("3. Cancel Movie");
	        System.out.println("4. Exit");
	        System.out.println("==============================");
	        System.out.print("Enter your choice: ");

	}
}
