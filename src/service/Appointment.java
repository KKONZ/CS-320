package service;

import java.util.Date;

/**
 * Appointment class that captures appointment information for the system
 */

public class Appointment {
	private final String id;
	private Date appointmentDate;
	private String description;
	
	/**
	 * @param id Unique appointment id, max 10 characters, not null, can not update
	 * @param appointmentDate Appointment date, not null, must be in the future
	 * @param description Appointment description, max 50 characters, not null
	 * @throws IllegalArgumentException for parameter violations
	 */
	public Appointment(String id, Date appointmentDate, String description) {
		validateStringField(id, 10, "id");
		this.id = id;
		
		setAppointmentDate(appointmentDate);
		setDescription(description);
	}
	
	/**
	 * Getter method for id
	 * 
	 * @return Unique appointment id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Getter method for appointmentDate
	 * 
	 * @return appointmentDate
	 */
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	/**
	 * Setter method for appointmentDate
	 * 
	 * @param appointmentDate
	 * @throws IllegalArgumentException
	 */
	public void setAppointmentDate(Date appointmentDate) {
		validateDate(appointmentDate);
		this.appointmentDate = appointmentDate;
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
	
	/**
	 * Helper method for validating date
	 * 
	 * @param date
	 * @throws IllegalArgumentException
	 */
	private static void validateDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("Invalid value for appointmentDate expected not null");
		}
		if (date.before(new Date())) {
			throw new IllegalArgumentException("Invalid value for appointmentDate expected future date");
		}
	}
}
