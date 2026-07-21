
public class InputValidator {

	    public static boolean isValidName(String name) {
	        return name != null && name.matches("[A-Za-z ]{2,50}");
	    }

	    
	    public static boolean isValidAge(int age) {
	        return age >= 12 && age <= 120;
	    }

	    public static boolean isValidEmail(String email) {
	        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
	    }

	    
	    public static boolean isValidPassword(String password) {
	        return password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
	    }

	    public static boolean isValidPhoneNumber(String phone_number) {
	        return phone_number != null && phone_number.matches("01\\d{8,9}");
	    }

		
	
}
