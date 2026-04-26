package service;

import java.util.HashMap;
import java.util.Map;

/**
 * Service for managing contacts
 * Keeps in-memory records via a hash-map
 * CRUD operations for contacts
 */
public class ContactService {
	private final Map<String, Contact> contacts;
	
	/**
	 * Instantiate ContactService to create a hash map
	 */
	public ContactService() {
		this.contacts = new HashMap<>();
	}

	/**
	 * Add contact
	 * 
	 * @param contact
	 * @throws IllegalArgumentException 
	 */
	public void addContact(Contact contact) {
		validateNotNull(contact);
		
		String id = contact.getId();
		if (contacts.containsKey(id) ) {
			throw new IllegalArgumentException("Id already exists");
		}
		
		contacts.put(id, contact);
	}
	
	/**
	 * Delete method for id
	 * 
	 * @param id
	 * @throws IllegalArgumentException
	 */
	public void deleteContact(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Null id");
		}
		
		if(!contacts.containsKey(id)) {
			throw new IllegalArgumentException(id + " does not exist");
		}
		
		contacts.remove(id);
	}
	
	/**
	 * Update method for first name
	 * 
	 * @param id
	 * @param firstName
	 * @throws IllegalArgumentException
	 */
	public void updateFirstName(String id, String firstName) {
		Contact contact = getContact(id);
		contact.setFirstName(firstName);
	}
	
	/**
	 * Update method for last name
	 * 
	 * @param id
	 * @param lastName
	 * @throws IllegalArgumentException
	 */
	public void updateLastName(String id, String lastName) {
		Contact contact = getContact(id);
		contact.setLastName(lastName);
	}
	
	/**
	 * Update method for phone number
	 * 
	 * @param id
	 * @param Number
	 * @throws IllegalArgumentException
	 */
	public void updateNumber(String id, String Number) {
		Contact contact = getContact(id);
		contact.setNumber(Number);
	}
	
	/**
	 * Update method for address
	 * 
	 * @param id
	 * @param Address
	 * @throws IllegalArgumentException
	 */
	public void updateAddress(String id, String Address) {
		Contact contact = getContact(id);
		contact.setAddress(Address);
	}
	
	
	/**
	 * 
	 * @param id
	 * @return contact record
	 * @throws IllegalArgumentException
	 */
	public Contact getContact(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Null id");
		}
		
		Contact contact = contacts.get(id);
		validateNotNull(contact);
			
		return contact;
	}
	
	/**
	 * Helper method for checking if value is null
	 * 
	 * @param value
	 * @throws IllegalArgumentException
	 */
	private static void validateNotNull(Object value) {
		if (value == null) {
			throw new IllegalArgumentException("Null value");
		}
	}
}
