package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import service.Contact;
import service.ContactService;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ContactService Class Tests")
class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    @Test
    @DisplayName("Add contact with unique ID succeeds")
    void testAddContactSuccess() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        contactService.addContact(contact);
        
        Contact retrieved = contactService.getContact("1234567890");
        assertNotNull(retrieved);
        assertEquals("1234567890", retrieved.getId());
        assertEquals("Karl", retrieved.getFirstName());
    }

    @Test
    @DisplayName("Add multiple contacts with unique IDs succeeds")
    void testAddMultipleContacts() {
        Contact contact1 = new Contact("1", "Karl", "Konz", "1234567890", "123456 St.");
        Contact contact2 = new Contact("2", "Scott", "McDaniels", "5555555555", "123 Place Blvd.");
        
        contactService.addContact(contact1);
        contactService.addContact(contact2);
        
        assertEquals("Karl", contactService.getContact("1").getFirstName());
        assertEquals("Scott", contactService.getContact("2").getFirstName());
    }

    @Test
    @DisplayName("Add contact with duplicate ID fails")
    void testAddContactDuplicateId() {
        Contact contact1 = new Contact("1", "Karl", "Konz", "1234567890", "123456 St.");
        Contact contact2 = new Contact("1", "Scott", "McDaniels", "5555555555", "123 Place Blvd.");
        
        contactService.addContact(contact1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    @Test
    @DisplayName("Add null contact fails")
    void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(null);
        });
    }

    @Test
    @DisplayName("Delete existing contact succeeds")
    void testDeleteContactSuccess() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        contactService.addContact(contact);
        
        contactService.deleteContact("1234567890");
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("1234567890");
        });
    }

    @Test
    @DisplayName("Delete non-existent contact fails")
    void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("9999999999");
        });
    }

    @Test
    @DisplayName("Delete with null ID fails")
    void testDeleteNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact(null);
        });
    }

    @Test
    @DisplayName("Update first name should succeeds")
    void testUpdateFirstNameSuccess() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");;
        contactService.addContact(contact);
        
        contactService.updateFirstName("1234567890", "Jane");
        
        assertEquals("Jane", contactService.getContact("1234567890").getFirstName());
    }

    @Test
    @DisplayName("Update first name for non-existent contact fails")
    void testUpdateFirstNameNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("9999999999", "Jane");
        });
    }

    @Test
    @DisplayName("Update first name with invalid value fails")
    void testUpdateFirstNameInvalid() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("1234567890", null);
        });
    }

    @Test
    @DisplayName("Update last name succeeds")
    void testUpdateLastNameSuccess() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        contactService.addContact(contact);
        
        contactService.updateLastName("1234567890", "Smith");
        
        assertEquals("Smith", contactService.getContact("1234567890").getLastName());
    }

    @Test
    @DisplayName("Update last name for non-existent contact fails")
    void testUpdateLastNameNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("9999999999", "Smith");
        });
    }

    @Test
    @DisplayName("Update last name with invalid value fails")
    void testUpdateLastNameInvalid() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("1234567890", null);
        });
    }

    @Test
    @DisplayName("Update phone succeeds")
    void testUpdateNumberSuccess() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        contactService.addContact(contact);
        
        contactService.updateNumber("1234567890", "9876543210");
        
        assertEquals("9876543210", contactService.getContact("1234567890").getNumber());
    }

    @Test
    @DisplayName("Update phone for non-existent contact fails")
    void testUpdateNumberNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateNumber("9999999999", "9876543210");
        });
    }

    @Test
    @DisplayName("Update phone with invalid value fails")
    void testUpdateNumberInvalid() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateNumber("1234567890", "123");
        });
    }

    @Test
    @DisplayName("Update address succeeds")
    void testUpdateAddressSuccess() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        contactService.addContact(contact);
        contactService.updateAddress("1234567890", "456 Oak Ave");
        assertEquals("456 Oak Ave", contactService.getContact("1234567890").getAddress());
    }

    @Test
    @DisplayName("Update address for non-existent contact fails")
    void testUpdateAddressNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("9999999999", "456 Oak Ave");
        });
    }

    @Test
    @DisplayName("Update address with invalid value fails")
    void testUpdateAddressInvalid() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("1234567890", null);
        });
    }

    @Test
    @DisplayName("Get existing contact succeeds")
    void testGetContactSuccess() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        contactService.addContact(contact);
        
        Contact retrieved = contactService.getContact("1234567890");
        
        assertNotNull(retrieved);
        assertEquals("1234567890", retrieved.getId());
        assertEquals("Karl", retrieved.getFirstName());
        assertEquals("Konz", retrieved.getLastName());
        assertEquals("1234567890", retrieved.getNumber());
        assertEquals("123456 St.", retrieved.getAddress());
    }

    @Test
    @DisplayName("Get non-existent contact should fail")
    void testGetNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("9999999999");
        });
    }

    @Test
    @DisplayName("Get contact with null ID should fail")
    void testGetContactNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact(null);
        });
    }
}
