package service;

import java.util.Scanner;

public class UserRegistration {

    public static boolean isUsernameValid(String username) {
        return username != null && username.length() >= 5 && username.length() <= 15;
    }

    public static boolean isPasswordValid(String password) {
        return password != null && password.length() >= 8; 
    }

    public static boolean register(String username, String password) {
    	if (!isUsernameValid(username)) {
    		System.out.println("Username should have characters between 5 and 15.");
    		return false;
    	}
    	
    	if (!isPasswordValid(password)) {
    		System.out.println("Password should have minimum 8 characters.");
    		return false;
    	}
    	
    	if (UserDatabase.userMap.containsKey(username)) {
    		System.out.println("already exists!");
    		return false;
    	}
    	
    	UserDatabase.userMap.put(username, password);
    	System.out.println("Successfull!");
    	return true;
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter your username: ");
    	String username = scanner.nextLine();
    	System.out.println("Enter your password: ");
    	String password = scanner.nextLine();
    	register(username, password);
    	scanner.close();
    }
}
