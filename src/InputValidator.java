
public class InputValidator {

    public static boolean isValidName(String name) {
        if (name == null) {
            return false;
        }

        String cleanName = name.trim();
		
        return cleanName.length() >= 2
                && cleanName.length() <= 50
                && cleanName.matches("[A-Za-z ]+");
    }

    public static boolean isValidAge(int age) {
        return age >= 12 && age <= 120;
    }


    public static boolean isValidPhoneNumber(String phone_number) {
        return phone_number != null && phone_number.matches("01[0-9]{8,9}");
    }

    public static boolean isValidStudentId(String studentId) {
        return studentId != null && studentId.matches("[A-Za-z0-9]{4,20}");
    }

}
