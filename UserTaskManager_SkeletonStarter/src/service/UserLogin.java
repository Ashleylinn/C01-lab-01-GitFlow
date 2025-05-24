package service;

import java.util.Scanner;

public class UserLogin {

    public static boolean login(String username, String password) {
        if (UserDatabase.userMap.containsKey(username)) {
        	String passwordStored = UserDatabase.userMap.get(username);
        	return passwordStored.equals(password);
        }
        return false;
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter your username: ");
    	String username = scanner.nextLine();
    	System.out.println("Enter your password: ");
    	String password = scanner.nextLine();
    	
    	if(login(username, password)) {
    		System.out.println("Login!");
    	} else {
    		System.out.println("Login failed!");
    	}
    	scanner.close();
    }
}
