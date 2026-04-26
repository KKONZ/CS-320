package service;

/**
 * Task class that captures task information for the system
 */

public class Task {
	private final String id;
	private String name;
	private String description;
	
	/**
	 * @param id Unique task id, max 10 characters, not null, can not update
	 * @param name Task name, max 20 characters, not null
	 * @param description Task description, max 50 characters, not null
	 * @throws IllegalArgumentException for parameter violations
	 */
	public Task(String id, String name, String description) {
		validateStringField(id, 10, "id");
		this.id = id;
		
		setName(name);
		setDescription(description);
	}
	
	/**
	 * Getter method for id
	 * 
	 * @return Unique task id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Getter method for name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter method for name
	 * 
	 * @param name
	 * @throws IllegalArgumentException
	 */
	public void setName(String name) {
		validateStringField(name, 20, "name");
		this.name = name;
	}
	
	/**
	 * Getter method for description
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Setter method for description
	 * 
	 * @param description
	 * @throws IllegalArgumentException
	 */
	public void setDescription(String description) {
		validateStringField(description, 50, "description");
		this.description = description;
	}
	
	/**
	 * Helper method to validate strings for length constraint
	 * 
	 * @param stringInputValue
	 * @param maxLength
	 * @param stringInputName
	 * @throws IllegalArgumentException
	 */
	private static void validateStringField(String stringInputValue,
			int maxLength,
			String stringInputName) {
		if (stringInputValue == null || stringInputValue.length() > maxLength) {
			throw new IllegalArgumentException("Invalid value for " + stringInputName + " expected <= " + maxLength);
		}
	}
}
