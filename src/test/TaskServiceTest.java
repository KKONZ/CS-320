package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import service.Task;
import service.TaskService;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TaskService Class Tests")
class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    @DisplayName("Add task with unique ID succeeds")
    void testAddTaskSuccess() {
        Task task = new Task("1234567890", "Task Name", "Task description here");
        taskService.addTask(task);
        
        Task retrieved = taskService.getTask("1234567890");
        assertNotNull(retrieved);
        assertEquals("1234567890", retrieved.getId());
        assertEquals("Task Name", retrieved.getName());
    }

    @Test
    @DisplayName("Add multiple tasks with unique IDs succeeds")
    void testAddMultipleTasks() {
        Task task1 = new Task("1", "First Task", "First task description");
        Task task2 = new Task("2", "Second Task", "Second task description");
        
        taskService.addTask(task1);
        taskService.addTask(task2);
        
        assertEquals("First Task", taskService.getTask("1").getName());
        assertEquals("Second Task", taskService.getTask("2").getName());
    }

    @Test
    @DisplayName("Add task with duplicate ID fails")
    void testAddTaskDuplicateId() {
        Task task1 = new Task("1", "First Task", "First task description");
        Task task2 = new Task("1", "Second Task", "Second task description");
        
        taskService.addTask(task1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task2);
        });
    }

    @Test
    @DisplayName("Add null task fails")
    void testAddNullTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(null);
        });
    }

    @Test
    @DisplayName("Delete existing task succeeds")
    void testDeleteTaskSuccess() {
        Task task = new Task("1234567890", "Task Name", "Task description here");
        taskService.addTask(task);
        
        taskService.deleteTask("1234567890");
        
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.getTask("1234567890");
        });
    }

    @Test
    @DisplayName("Delete non-existent task fails")
    void testDeleteNonExistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("9999999999");
        });
    }

    @Test
    @DisplayName("Delete with null ID fails")
    void testDeleteNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask(null);
        });
    }

    @Test
    @DisplayName("Update name succeeds")
    void testUpdateNameSuccess() {
        Task task = new Task("1234567890", "Task Name", "Task description here");
        taskService.addTask(task);
        
        taskService.updateName("1234567890", "Updated Name");
        
        assertEquals("Updated Name", taskService.getTask("1234567890").getName());
    }

    @Test
    @DisplayName("Update name for non-existent task fails")
    void testUpdateNameNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateName("9999999999", "Updated Name");
        });
    }

    @Test
    @DisplayName("Update name with invalid value fails")
    void testUpdateNameInvalid() {
        Task task = new Task("1234567890", "Task Name", "Task description here");
        taskService.addTask(task);
        
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateName("1234567890", null);
        });
    }

    @Test
    @DisplayName("Update description succeeds")
    void testUpdateDescriptionSuccess() {
        Task task = new Task("1234567890", "Task Name", "Task description here");
        taskService.addTask(task);
        
        taskService.updateDescription("1234567890", "Updated description");
        
        assertEquals("Updated description", taskService.getTask("1234567890").getDescription());
    }

    @Test
    @DisplayName("Update description for non-existent task fails")
    void testUpdateDescriptionNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateDescription("9999999999", "Updated description");
        });
    }

    @Test
    @DisplayName("Update description with invalid value fails")
    void testUpdateDescriptionInvalid() {
        Task task = new Task("1234567890", "Task Name", "Task description here");
        taskService.addTask(task);
        
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateDescription("1234567890", null);
        });
    }

    @Test
    @DisplayName("Get existing task succeeds")
    void testGetTaskSuccess() {
        Task task = new Task("1234567890", "Task Name", "Task description here");
        taskService.addTask(task);
        
        Task retrieved = taskService.getTask("1234567890");
        
        assertNotNull(retrieved);
        assertEquals("1234567890", retrieved.getId());
        assertEquals("Task Name", retrieved.getName());
        assertEquals("Task description here", retrieved.getDescription());
    }

    @Test
    @DisplayName("Get non-existent task fails")
    void testGetNonExistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.getTask("9999999999");
        });
    }

    @Test
    @DisplayName("Get task with null ID fails")
    void testGetTaskNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.getTask(null);
        });
    }
}
