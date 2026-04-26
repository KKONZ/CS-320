package service;

/**
 * Contact class that captures personal information for user
 */

public class Contact {
	private final String id;
	private String firstName;
	private String lastName;
	private String Number;
	private String Address;
	
	/**
	 * @param id Unique contact id, max 10 characters, not null, can not update
	 * @param firstName First name, max 10 characters, not null
	 * @param lastName Last name , max 10 characters, not null
	 * @param Number Phone number, exactly 10 digits, not null
	 * @param Address Address, max 30 characters, not null
	 * @throws IllegalArgumentException for parameter violations
	 */
	public Contact( String id, 
			String firstName, 
			String lastName, 
			String Number,  
			String Address) {
		validateStringField(id, 10, "id");
		this.id = id;
		
		setFirstName(firstName);
		setLastName(lastName);
		setNumber(Number);
		setAddress(Address);
	}
	
	/**
	 * Getter method for id
	 * 
	 * @return Unique contact id
	 */
	public String getId() {
		return id;
	}
	
	
	/**
	 * Getter method for first name
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter method for first name
	 * 
	 * @param firstName
	 * @throws IllegalArgumentException
	 */
	public void setFirstName(String firstName) {
		validateStringField(firstName, 10, "firstName");
		this.firstName = firstName;
	}
	
	/**
	 * Getter method for last name
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Setter method for last name
	 * 
	 * @param lastName
	 * throws IllegalArgumentException
	 */
	public void setLastName(String lastName) {
		validateStringField(lastName, 10, "lastName");
		this.lastName = lastName;
	}
	
	/**
	 * Getter method for phone number
	 * 
	 * @return lastName
	 */
	public String getNumber() {
		return Number;
	}
	
	/**
	 * Setter method for phone number
	 * 
	 * @param Number
	 * throws IllegalArgumentException
	 */
	public void setNumber(String Number) {
		validateNumber(Number);
		this.Number = Number;
	}

	/**
	 * Getter method for address
	 * 
	 * @return address
	 */
	public String getAddress() {
		return Address;
	}
	
	/**
	 * Setter method for address
	 * 
	 * @param Address
	 * throws IllegalArgumentException
	 */
	public void setAddress(String Address) {
		validateStringField(Address, 30, "Address");
		this.Address = Address;
	}
	
	/**
	 * Helper method to validate strings for length constraint
	 * 
	 * @param stringInputValue
	 * @param maxLength
	 * @param stringInputName
	 * @throws IllegalArgumentExcpetion
	 */
	private static void validateStringField (String stringInputValue,
			int maxLength,
			String stringInputName) {
		if (stringInputValue == null || stringInputValue.length() > maxLength) {
			throw new IllegalArgumentException("Invalid value for " + stringInputName + " expected <= " + maxLength);
		}
	}
	 
	/**
	 * Helper method for validating phone number
	 * 
	 * @param Number
	 * @throws IllegalArgumentException
	 */
	private static void validateNumber(String Number) {
		if (Number == null || !Number.matches("\\d{10}")) {
			throw new IllegalArgumentException("Expected phone number to have 10 digits");
		}
	}
}
