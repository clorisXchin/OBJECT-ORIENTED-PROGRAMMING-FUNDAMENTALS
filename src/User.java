
public class User {

    private String name;
    private int age;
    private String email;
    private String phonenumber;

    public User(String name, int age, String email, String phonenumber) {
        setName(name);
        setAge(age);
        setEmail(email);
        setPhonenumber(phonenumber);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (InputValidator.isValidName(name)) {
            this.name = name.trim();
        } else {
            throw new IllegalArgumentException("Name must contain only letters and spaces.");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (InputValidator.isValidAge(age)) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be between 12 and 120.");
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (InputValidator.isValidEmail(email)) {
            this.email = email; 
        }else {
            throw new IllegalArgumentException("Invalid email format.Please include '@' and a valid domain.");
        }
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        if (InputValidator.isValidPhoneNumber(phonenumber)) {
            this.phonenumber = phonenumber; 
        }else {
            throw new IllegalArgumentException("Phone numbers start with 01 and contain 10 digits.");
        }
    }

    @Override
    public String toString() {
        return "User [name: " + name + ", age: " + age + ", email: " + email + ", phone_number: "
                + phonenumber + "]";
    }

}
