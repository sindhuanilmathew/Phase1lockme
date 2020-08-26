package com.dell.lockme.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.dell.lockme.model.Credentials;
import com.dell.lockme.model.Users;

public class Authentication {
	private static Scanner userInput;
	private static Scanner input;
	private static Scanner lockerUserInput;
	private static PrintWriter output;
	private static PrintWriter lockerOutput;
	private static Users users;
	private static Credentials userLockerCredentials;

	public static void main(String[] args) {
		initApp();
		welcomeScreen();
		signInOptions();

	}

	public static void signInOptions() {
		System.out.println("1->Login ");
		System.out.println("2->Registration ");
		int option = userInput.nextInt();
		switch (option) {
		case 1:
			loginUser();
			break;
		case 2:
			registerUser();
			break;
		default:
			System.out.println("Please select 1 Or 2");
			break;
		}
		userInput.close();
		input.close();
	}

	public static void lockerOptions(String inputName) {
		System.out.println("1->Store Credentials ");
		System.out.println("2->Fetch all stored Credentials ");
		int option = userInput.nextInt();
		switch (option) {
		case 1:
			storeCredentials(inputName);
			break;
		case 2:
			fetchCredentials(inputName);
			break;
		default:
			System.out.println("Please select 1 Or 2");
			break;
		}
		lockerUserInput.close();
	}

	public static void registerUser() {
		System.out.println("					");
		System.out.println("   WELCOME TO LOCKME APP REGISTRATION PAGE	");
		System.out.println("					");

		System.out.println("Enter Username :");
		String username = userInput.next();
		users.setUsername(username);

		System.out.println("Enter Password :");
		String password = userInput.next();
		users.setUserPassword(password);

		output.println(users.getUsername());
		output.println(users.getUserPassword());

		System.out.println("User Registration Successful !");
		output.close();

	}

	public static void loginUser() {
		System.out.println("					");
		System.out.println("   WELCOME TO LOCKME APP LOGIN PAGE	 ");
		System.out.println("					");
		System.out.println("Enter Username :");
		String inputName = userInput.next();
		boolean found = false;
		while (input.hasNext() && !found) {
			if (input.next().equals(inputName)) {
				System.out.println("Enter Password :");
				String inputPassword = userInput.next();
				if (input.next().equals(inputPassword)) {
					System.out.println("Login Successful");
					found = true;
					lockerOptions(inputName);
					break;
				}
			}
		}
		if (!found) {
			System.out.println("User Not Found : Login Failure : 404");
		}

	}

	public static void welcomeScreen() {
		System.out.println("					");
		System.out.println("   Welcome To LockMe.com		");
		System.out.println("   Your Personal Digital Locker	");
		System.out.println("					");
	}

	public static void storeCredentials(String loggedInUser) {
		System.out.println("					");
		System.out.println("   WELCOME TO DIGITAL LOCKER STORE ");
		System.out.println("    YOUR CREDENTIALS ARE SAFE HERE	 ");
		System.out.println("					");

		userLockerCredentials.setLoggedInUser(loggedInUser);

		System.out.println("Enter Site Name :");
		String siteName = userInput.next();
		userLockerCredentials.setSocialSiteName(siteName);

		System.out.println("Enter Username :");
		String username = userInput.next();
		userLockerCredentials.setUsername(username);

		System.out.println("Enter Password :");
		String password = userInput.next();
		userLockerCredentials.setPassword(password);

		lockerOutput.println(userLockerCredentials.getLoggedInUser());
		lockerOutput.println(userLockerCredentials.getSocialSiteName());
		lockerOutput.println(userLockerCredentials.getUsername());
		lockerOutput.println(userLockerCredentials.getPassword());

		System.out.println("YOUR CREDENTIALS ARE STORED AND SECURED!");
		lockerOutput.close();
	}

	public static void fetchCredentials(String inputName) {
		System.out.println("					");
		System.out.println("   WELCOME TO DIGITAL LOCKER 	 ");
		System.out.println("   YOUR CREDENTIALS ARE 	 ");
		System.out.println("					");
		System.out.println(inputName);

		while (lockerUserInput.hasNext()) {
			if (lockerUserInput.next().equals(inputName)) {
				System.out.println("Site Name: " + lockerUserInput.next());
				System.out.println("User Name: " + lockerUserInput.next());
				System.out.println("User Password: " + lockerUserInput.next());
			}
		}

	}

	public static void initApp() {

		File dbFile = new File("credentials.txt");
		File lockerFile = new File("locker-credentails.txt");

		try {
			input = new Scanner(dbFile);

			lockerUserInput = new Scanner(lockerFile);

			userInput = new Scanner(System.in);

			output = new PrintWriter(new FileWriter(dbFile, true));
			lockerOutput = new PrintWriter(new FileWriter(lockerFile, true));

			users = new Users();
			userLockerCredentials = new Credentials();

		} catch (IOException e) {
			System.out.println("404 : File Not Found ");
		}

	}

}
