package cinema;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
public class Showtime {
 
	private String showtimeId;
	private LocalDate showDate;
	private String time;
	private Movie movie; //Aggregation: Showtime HAS - A Movie
	private Hall hall;
	
	// Constructor
	public Showtime(String showtimeId,LocalDate showDate, String time, Movie movie, Hall hall) {
		this.showtimeId = showtimeId;
		this.time = time ;
		this.showDate = showDate; 
		this.movie = movie;
		this.hall = hall;
	}

	public String getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(String showtimeId) {
		this.showtimeId = showtimeId;
	}

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Hall getHallId() {
		return hall;
	}

	public void setHallId(Hall hallId) {
		this.hall = hall;
	}
	
	public void displayShowtime() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String formattedDate = (showDate !=null)? showDate.format(dateFormatter):"N/A";
		
		System.out.println("Showtime ID: ["+showtimeId +"]" 
				+"\nDate:"+formattedDate
				+"\nTime:" +time+ ""
				+ "\nHall:"+ hall
				+"\n\t---Movie Information ---");
		
		if (movie != null) {
			movie.displayMovie();
		}
		
	}
}
