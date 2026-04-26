package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import service.Contact;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Contact Class Tests")
class ContactTest {

	@Test
	@DisplayName("Contact memory tests")
	void testContactCreateSuccess() {
		Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
		
		assertEquals("1234567890", contact.getId());
		assertEquals("Karl", contact.getFirstName());
		assertEquals("Konz", contact.getLastName());
		assertEquals("1234567890", contact.getNumber());
		assertEquals("123456 St.", contact.getAddress());
	}
	
	@Test
	@DisplayName("Id not null")
	void testIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Karl", "Konz", "1234567890", "123456 St.");
		});
	}
	
	@Test
	@DisplayName("Id not longer than 10 characters")
	void testIdLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "Karl", "Konz", "1234567890", "123456 St.");
		});
	}

	@Test
	@DisplayName("First name not null")
	void testFirstNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", null, "Konz", "1234567890", "123456 St.");
		});
	}
	
	@Test
	@DisplayName("First name not longer than 10 characters")
	void testFirstNameLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Karlkarlkarl", "Konz", "1234567890", "123456 St.");
		});
	}

	
	
    @Test
    @DisplayName("First name can be updated with valid value")
    void testUpdateFirstNameSuccess() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        contact.setFirstName("John");
        assertEquals("John", contact.getFirstName());
    }

    @Test
    @DisplayName("First name update with null fails")
    void testUpdateFirstNameNull() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }
    
    

    @Test
    @DisplayName("First name update with too long value fails")
    void testUpdateFirstNameTooLong() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("JaneJaneJane");
        });
    }

    @Test
    @DisplayName("Last name cannot be null")
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Karl", null, "1234567890", "123456 St.");
        });
    }

    @Test
    @DisplayName("Last name cannot be longer than 10 characters")
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Karl", "KonzKonzKonz", "1234567890", "123456 St.");
        });
    }

    @Test
    @DisplayName("Last name can be updated with valid value")
    void testUpdateLastNameSuccess() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    @DisplayName("Last name update with null fails")
    void testUpdateLastNameNull() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    @Test
    @DisplayName("Last name update with too long value fails")
    void testUpdateLastNameTooLong() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("KonzKonzKonz");
        });
    }

    @Test
    @DisplayName("Phone cannot be null")
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Karl", "Konz", null, "123456 St.");
        });
    }

    @Test
    @DisplayName("Phone must be exactly 10 digits, short")
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Karl", "Konz", "123456789", "123456 St.");
        });
    }

    @Test
    @DisplayName("Phone must be exactly 10 digits, long")
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Karl", "Konz", "12345678901", "123456 St.");
        });
    }

    @Test
    @DisplayName("Phone must contain only digits")
    void testPhoneNonDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Karl", "Konz", "(123)-456-7890", "123456 St.");
        });
    }

    @Test
    @DisplayName("Phone can be updated with valid value")
    void testUpdatePhoneSuccess() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        contact.setNumber("9876543210");
        assertEquals("9876543210", contact.getNumber());
    }

    @Test
    @DisplayName("Phone update with null fails")
    void testUpdatePhoneNull() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setNumber(null);
        });
    }

    @Test
    @DisplayName("Phone update with invalid format fails")
    void testUpdatePhoneInvalid() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setNumber("123456789");
        });
    }

    @Test
    @DisplayName("Address cannot be null")
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Karl", "Konz", "1234567890", null);
        });
    }

    @Test
    @DisplayName("Address cannot be longer than 30 characters")
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Karl", "Konz", "1234567890", "1234567890123456789012345678901");
        });
    }

    @Test
    @DisplayName("Address can be updated with valid value")
    void testUpdateAddressSuccess() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        contact.setAddress("123456 Main");
        assertEquals("123456 Main", contact.getAddress());
    }

    @Test
    @DisplayName("Address update with null fails")
    void testUpdateAddressNull() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    @Test
    @DisplayName("Address update with too long value fails")
    void testUpdateAddressTooLong() {
        Contact contact = new Contact("1234567890", "Karl", "Konz", "1234567890", "123456 St.");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("1234567890123456789012345678901");
        });
    }

}
