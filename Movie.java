package cinema;

//Class
public class Movie {
 private String movieId;
 private String movieTitle;
 private String movieGenre;
 private String movieLanguage;
 private String movieCode;
 private int durationMins;
 
 //Constructor
 public Movie(String movieId,String movieTitle,String movieGenre,String movieLanguage,String movieCode, int durationMins) {
	 this.movieId= movieId;
	 this.movieTitle=movieTitle;
	 this.movieGenre=movieGenre;
	 this.movieLanguage=movieLanguage;
	 this.movieCode=movieCode;
	 this.durationMins=durationMins;
 }
// Getter and Setter
 public String getMovieId() {
	return movieId;
 }

 public void setMovieId(String movieId) {
	this.movieId = movieId;
 }

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

 public String getMovieCode() {
	return movieCode;
 }

 public void setMovieCode(String movieCode) {
	this.movieCode = movieCode;
 }

 public int getDurationMins() {
	return durationMins;
 }

 public void setDurationMins(int durationMins) {
	this.durationMins = durationMins;
 }
 
 //Display in console
 public void displayMovie() {
	 System.out.println("["+ movieId + "]" + movieTitle + "(" + movieGenre  + movieLanguage+ movieCode+ durationMins+"min");
 }
 
 
 
}

