
public class User {
	
	private String name;
	private int age;
	private String email;
	private String password;
	private String phone_number;
	
	public User() {
		
	}

	public User(String name, int age, String email, String password, String phone_number) {
		super();
		setName(name);
		setAge(age);
		setEmail(email);
		setPassword(password);
		setPhone_number(phone_number);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (InputValidator.isValidName(name))
		this.name = name;
		else
			System.out.println("Please fill in the blank");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (InputValidator.isValidAge(age))
		this.age = age;
		else
		    throw new IllegalArgumentException("Age must be between 12 and 120.");
		   
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (InputValidator.isValidEmail(email)) 
	        this.email = email;
	    else {
	        throw new IllegalArgumentException("Invalid email format.");
	    }
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (InputValidator.isValidPassword(password))
		this.password = password;
		else
			throw new IllegalArgumentException("Please try again.");
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		if (InputValidator.isValidPhoneNumber(phone_number))
		this.phone_number = phone_number;
		else 
			throw new IllegalArgumentException("Phone numbers can only contain digits.");
	}

	@Override
	public String toString() {
		return "User [name: " + name + ", age: " + age + ", email: " + email + ", password: " + password + ", phone_number: "
				+ phone_number + "]";
	} 
	
	
}

