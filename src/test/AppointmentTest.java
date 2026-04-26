package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import service.Appointment;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Appointment Class Tests")
class AppointmentTest {

	@Test
	@DisplayName("Appointment created successfully with valid parameters")
	void testAppointmentCreateSuccess() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		Appointment appointment = new Appointment("1234567890", futureDate, "Annual checkup");
		
		assertEquals("1234567890", appointment.getId());
		assertEquals(futureDate, appointment.getAppointmentDate());
		assertEquals("Annual checkup", appointment.getDescription());
	}
	
	@Test
	@DisplayName("Id not null")
	void testIdNull() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, futureDate, "Annual checkup");
		});
	}
	
	@Test
	@DisplayName("Id not longer than 10 characters")
	void testIdLong() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678901", futureDate, "Annual checkup");
		});
	}

	@Test
	@DisplayName("Appointment date not null")
	void testAppointmentDateNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", null, "Annual checkup");
		});
	}
	
	@Test
	@DisplayName("Appointment date not in past")
	void testAppointmentDatePast() {
		Date pastDate = new Date(System.currentTimeMillis() - 86400000);
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", pastDate, "Annual checkup");
		});
	}

	@Test
	@DisplayName("Appointment date accepts future date")
	void testAppointmentDateFuture() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		Appointment appointment = new Appointment("1234567890", futureDate, "Annual checkup");
		assertEquals(futureDate, appointment.getAppointmentDate());
	}

	@Test
	@DisplayName("Description not null")
	void testDescriptionNull() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", futureDate, null);
		});
	}
	
	@Test
	@DisplayName("Description not longer than 50 characters")
	void testDescriptionLong() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", futureDate, "123456789012345678901234567890123456789012345678901");
		});
	}

	@Test
	@DisplayName("Appointment date can be updated with valid future date")
	void testUpdateAppointmentDateSuccess() {
		Date futureDate1 = new Date(System.currentTimeMillis() + 86400000);
		Date futureDate2 = new Date(System.currentTimeMillis() + 172800000);
		Appointment appointment = new Appointment("1234567890", futureDate1, "Annual checkup");
		appointment.setAppointmentDate(futureDate2);
		assertEquals(futureDate2, appointment.getAppointmentDate());
	}

	@Test
	@DisplayName("Appointment date update with past date fails")
	void testUpdateAppointmentDatePast() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		Date pastDate = new Date(System.currentTimeMillis() - 86400000);
		Appointment appointment = new Appointment("1234567890", futureDate, "Annual checkup");
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setAppointmentDate(pastDate);
		});
	}

	@Test
	@DisplayName("Description can be updated with valid value")
	void testUpdateDescriptionSuccess() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		Appointment appointment = new Appointment("1234567890", futureDate, "Annual checkup");
		appointment.setDescription("Dental cleaning");
		assertEquals("Dental cleaning", appointment.getDescription());
	}

	@Test
	@DisplayName("Description update with null fails")
	void testUpdateDescriptionNull() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		Appointment appointment = new Appointment("1234567890", futureDate, "Annual checkup");
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDescription(null);
		});
	}

	@Test
	@DisplayName("Description update with too long value fails")
	void testUpdateDescriptionTooLong() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		Appointment appointment = new Appointment("1234567890", futureDate, "Annual checkup");
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDescription("123456789012345678901234567890123456789012345678901");
		});
	}
}
