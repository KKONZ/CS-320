package service;

import java.util.HashMap;
import java.util.Map;

/**
 * Service for managing tasks
 * Keeps in-memory records via a hash-map
 * CRUD operations for tasks
 */
public class TaskService {
	private final Map<String, Task> tasks;
	
	/**
	 * Instantiate TaskService to create a hash map
	 */
	public TaskService() {
		this.tasks = new HashMap<>();
	}

	/**
	 * Add task
	 * 
	 * @param task
	 * @throws IllegalArgumentException 
	 */
	public void addTask(Task task) {
		validateNotNull(task);
		
		String id = task.getId();
		if (tasks.containsKey(id)) {
			throw new IllegalArgumentException("Id already exists");
		}
		
		tasks.put(id, task);
	}
	
	/**
	 * Delete method for id
	 * 
	 * @param id
	 * @throws IllegalArgumentException
	 */
	public void deleteTask(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Null id");
		}
		
		if(!tasks.containsKey(id)) {
			throw new IllegalArgumentException(id + " does not exist");
		}
		
		tasks.remove(id);
	}
	
	/**
	 * Update method for name
	 * 
	 * @param id
	 * @param name
	 * @throws IllegalArgumentException
	 */
	public void updateName(String id, String name) {
		Task task = getTask(id);
		task.setName(name);
	}
	
	/**
	 * Update method for description
	 * 
	 * @param id
	 * @param description
	 * @throws IllegalArgumentException
	 */
	public void updateDescription(String id, String description) {
		Task task = getTask(id);
		task.setDescription(description);
	}
	
	/**
	 * 
	 * @param id
	 * @return task record
	 * @throws IllegalArgumentException
	 */
	public Task getTask(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Null id");
		}
		
		Task task = tasks.get(id);
		validateNotNull(task);
			
		return task;
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
