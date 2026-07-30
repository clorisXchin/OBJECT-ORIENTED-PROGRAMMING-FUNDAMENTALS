package cinema;

import java.time.LocalDate;

public class testCinema {
	    public static void main(String[] args) {
	        // Create a movie object
	        Movie movie1 = new Movie("M01", "Avengers: Endgame", "Action","English","P13", 181);
	        
	        Hall hall1 = new Hall("H1",5,6);
	        
	        LocalDate showDate = LocalDate.of(2026,7,30);
	        
	        // Test movie display
	        System.out.println("--- Testing Movie Class ---");
	        movie1.displayMovie();
	        	      
	        
	        Showtime slot1 = new Showtime("S01",showDate,"14:30",movie1,hall1);
	        System.out.println("\n--- Testing Showtime Class ---");
	        slot1.displayShowtime();
	        
	        
}}


