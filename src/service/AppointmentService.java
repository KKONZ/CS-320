package service;

import java.util.HashMap;
import java.util.Map;

/**
 * AppointmentService class that manages appointment records
 */
public class AppointmentService {
	private final Map<String, Appointment> appointments;
	
	/**
	 * Constructor that initializes the appointment storage
	 */
	public AppointmentService() {
		this.appointments = new HashMap<>();
	}
	
	/**
	 * Adds an appointment to the system with unique ID validation
	 * 
	 * @param appointment The appointment to add
	 * @throws IllegalArgumentException if appointment is null or ID already exists
	 */
	public void addAppointment(Appointment appointment) {
		validateNotNull(appointment);
		
		String id = appointment.getId();
		if (appointments.containsKey(id)) {
			throw new IllegalArgumentException("Id already exists");
		}
		
		appointments.put(id, appointment);
	}
	
	/**
	 * Deletes an appointment by ID
	 * 
	 * @param id The appointment ID to delete
	 * @throws IllegalArgumentException if ID is null or does not exist
	 */
	public void deleteAppointment(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Null id");
		}
		
		if (!appointments.containsKey(id)) {
			throw new IllegalArgumentException(id + " does not exist");
		}
		
		appointments.remove(id);
	}
	
	/**
	 * Retrieves an appointment by ID (helper method for internal use)
	 * 
	 * @param id The appointment ID to retrieve
	 * @return The appointment object
	 * @throws IllegalArgumentException if ID is null or does not exist
	 */
	public Appointment getAppointment(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Null id");
		}
		
		if (!appointments.containsKey(id)) {
			throw new IllegalArgumentException(id + " does not exist");
		}
		
		return appointments.get(id);
	}
	
	/**
	 * Private helper method to validate object is not null
	 * 
	 * @param value The object to validate
	 * @throws IllegalArgumentException if value is null
	 */
	private void validateNotNull(Object value) {
		if (value == null) {
			throw new IllegalArgumentException("Null value");
		}
	}
}
