
//Class
public class Movie {

    private String movieTitle;
    private String movieGenre;
    private String movieLanguage;

    private int durationMins;

    //Constructor
    public Movie( String movieTitle, String movieGenre, String movieLanguage, int durationMins) {
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.movieLanguage = movieLanguage;

        this.durationMins = durationMins;
    }
// Getter and Setter

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public int getDurationMins() {
        return durationMins;
    }

    public void setDurationMins(int durationMins) {
        this.durationMins = durationMins;
    }

}
