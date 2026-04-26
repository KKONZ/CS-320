package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import service.Task;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Task Class Tests")
class TaskTest {

	@Test
	@DisplayName("Task creation with valid inputs")
	void testTaskCreateSuccess() {
		Task task = new Task("1234567890", "Task Name", "Task Description");
		
		assertEquals("1234567890", task.getId());
		assertEquals("Task Name", task.getName());
		assertEquals("Task Description", task.getDescription());
	}
	
	@Test
	@DisplayName("Id not null")
	void testIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Task Name", "Task Description");
		});
	}
	
	@Test
	@DisplayName("Id not longer than 10 characters")
	void testIdLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "Task Name", "Task Description");
		});
	}

	@Test
	@DisplayName("Name not null")
	void testNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", null, "Task Description");
		});
	}
	
	@Test
	@DisplayName("Name not longer than 20 characters")
	void testNameLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "TaskNameTaskNameTaskName", "Task Description");
		});
	}

	@Test
	@DisplayName("Name can be updated with valid value")
	void testUpdateNameSuccess() {
		Task task = new Task("1234567890", "Task Name", "Task Description");
		task.setName("Updated Name");
		assertEquals("Updated Name", task.getName());
	}

	@Test
	@DisplayName("Name update with null fails")
	void testUpdateNameNull() {
		Task task = new Task("1234567890", "Task Name", "Task Description");
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName(null);
		});
	}

	@Test
	@DisplayName("Name update with too long value fails")
	void testUpdateNameTooLong() {
		Task task = new Task("1234567890", "Task Name", "Task Description");
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName("TaskNameTaskNameTaskName");
		});
	}

	@Test
	@DisplayName("Description not null")
	void testDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "Task Name", null);
		});
	}
	
	@Test
	@DisplayName("Description not longer than 50 characters")
	void testDescriptionLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "Task Name", "TaskDescriptionTaskDescriptionTaskDescriptionTaskDescription");
		});
	}

	@Test
	@DisplayName("Description can be updated with valid value")
	void testUpdateDescriptionSuccess() {
		Task task = new Task("1234567890", "Task Name", "Task Description");
		task.setDescription("Updated Description");
		assertEquals("Updated Description", task.getDescription());
	}

	@Test
	@DisplayName("Description update with null fails")
	void testUpdateDescriptionNull() {
		Task task = new Task("1234567890", "Task Name", "Task Description");
		assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription(null);
		});
	}

	@Test
	@DisplayName("Description update with too long value fails")
	void testUpdateDescriptionTooLong() {
		Task task = new Task("1234567890", "Task Name", "Task Description");
		assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription("TaskDescriptionTaskDescriptionTaskDescriptionTaskDescription");
		});
	}

}
