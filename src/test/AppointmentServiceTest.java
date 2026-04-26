package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import service.Appointment;
import service.AppointmentService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AppointmentService Class Tests")
class AppointmentServiceTest {

	private AppointmentService service;
	private Date futureDate;

	@BeforeEach
	void setUp() {
		service = new AppointmentService();
		futureDate = new Date(System.currentTimeMillis() + 86400000);
	}

	@Test
	@DisplayName("Appointment added successfully with unique ID")
	void testAddAppointmentSuccess() {
		Appointment appointment = new Appointment("1234567890", futureDate, "Annual checkup");
		service.addAppointment(appointment);
		
		Appointment retrieved = service.getAppointment("1234567890");
		assertEquals("1234567890", retrieved.getId());
		assertEquals(futureDate, retrieved.getAppointmentDate());
		assertEquals("Annual checkup", retrieved.getDescription());
	}

	@Test
	@DisplayName("Multiple appointments added successfully with unique IDs")
	void testAddMultipleAppointments() {
		Appointment appointment1 = new Appointment("1234567890", futureDate, "Annual checkup");
		Appointment appointment2 = new Appointment("0987654321", futureDate, "Dental cleaning");
		
		service.addAppointment(appointment1);
		service.addAppointment(appointment2);
		
		Appointment retrieved1 = service.getAppointment("1234567890");
		Appointment retrieved2 = service.getAppointment("0987654321");
		
		assertEquals("1234567890", retrieved1.getId());
		assertEquals("0987654321", retrieved2.getId());
	}

	@Test
	@DisplayName("Duplicate ID rejected on add")
	void testAddAppointmentDuplicateId() {
		Appointment appointment1 = new Appointment("1234567890", futureDate, "Annual checkup");
		Appointment appointment2 = new Appointment("1234567890", futureDate, "Dental cleaning");
		
		service.addAppointment(appointment1);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(appointment2);
		});
	}

	@Test
	@DisplayName("Null appointment rejected on add")
	void testAddAppointmentNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(null);
		});
	}

	@Test
	@DisplayName("Appointment deleted successfully")
	void testDeleteAppointmentSuccess() {
		Appointment appointment = new Appointment("1234567890", futureDate, "Annual checkup");
		service.addAppointment(appointment);
		
		service.deleteAppointment("1234567890");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.getAppointment("1234567890");
		});
	}

	@Test
	@DisplayName("Non-existent ID rejected on delete")
	void testDeleteAppointmentNonExistent() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppointment("9999999999");
		});
	}

	@Test
	@DisplayName("Null ID rejected on delete")
	void testDeleteAppointmentNullId() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppointment(null);
		});
	}

	@Test
	@DisplayName("Appointment retrieved successfully by ID")
	void testGetAppointmentSuccess() {
		Appointment appointment = new Appointment("1234567890", futureDate, "Annual checkup");
		service.addAppointment(appointment);
		
		Appointment retrieved = service.getAppointment("1234567890");
		
		assertNotNull(retrieved);
		assertEquals("1234567890", retrieved.getId());
		assertEquals(futureDate, retrieved.getAppointmentDate());
		assertEquals("Annual checkup", retrieved.getDescription());
	}

	@Test
	@DisplayName("Non-existent ID rejected on get")
	void testGetAppointmentNonExistent() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.getAppointment("9999999999");
		});
	}

	@Test
	@DisplayName("Null ID rejected on get")
	void testGetAppointmentNullId() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.getAppointment(null);
		});
	}
}
