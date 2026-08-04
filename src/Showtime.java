
import java.time.LocalDate;

public class Showtime {

    private String showtimeId;
    private LocalDate showDate;
    private String time;
    private Movie movie; //Aggregation: Showtime HAS - A Movie
    private Hall hall;
    private double basePrice;
    // Constructor

    public Showtime(String showtimeId, LocalDate showDate, String time, Movie movie, Hall hall, double basePrice) {
        this.showtimeId = showtimeId;
        this.time = time;
        this.showDate = showDate;
        this.movie = movie;
        this.hall = hall;
        setBasePrice(basePrice);
    }

    public String getShowtimeId() {
        return showtimeId;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public String getTime() {
        return time;
    }

    public Movie getMovie() {
        return movie;
    }

    public Hall getHall() {
        return hall;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException(
                    "Base price must be more than RM0.00.");
        }

        this.basePrice = basePrice;
    }
}
