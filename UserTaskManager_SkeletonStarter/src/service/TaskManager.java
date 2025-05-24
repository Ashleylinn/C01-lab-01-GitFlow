package service;

import model.Task;
import java.util.*;

public class TaskManager {

    public static void addTask(String username, String title, String desc) {
    	Task task = new Task(title, desc);
    	List<Task> tasks = UserDatabase.userTasks.getOrDefault(username, new ArrayList<>());
    	tasks.add(task);
    	UserDatabase.userTasks.put(username, tasks);
    }

    public static List<Task> getTasks(String username) {
        return UserDatabase.userTasks.getOrDefault(username, new ArrayList<>());
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter your name: ");
    	String username = scanner.nextLine();
    	
    	while(true) {
    		System.out.println("\n1. Add Task");
    		System.out.println("2. View Task");
    		System.out.println("3. Exit");
    		System.out.println("Select an option: ");
    		int option = scanner.nextInt();
    		scanner.nextLine();
    		
    		if (option == 1) {
    			System.out.println("Title: ");
    			String title = scanner.nextLine();
    			System.out.println("Description: ");
    			String desc = scanner.nextLine();
    			addTask(username, title, desc);
    			System.out.println("Task added!");
    		} else if(option == 2) {
    			List<Task> tasks = getTasks(username);
    			if(tasks.isEmpty()) {
    				System.out.println("Cannot found");
    			} else {
    				System.out.println("Tasks: ");
    				for (Task task : tasks) {
    					System.out.println(task);
    				}
    			}
    		} else {
    			break;
    		}
    	}
    	scanner.close();
    }
}
