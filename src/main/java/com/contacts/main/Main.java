package com.contacts.main;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.contacts.contact.Contact;
import com.contacts.methods.Methods;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File("PhoneBook.txt");
		Scanner scan = new Scanner(System.in);

		int choice, fileNumber = 1;
		try {
			if (!file.exists())
				file.createNewFile();
			while (true) {
				System.out.println("Enter a choice:");
				System.out.println("1.Create new Contact\t2.View\t3.Search\t4.Export\t5.Exit");
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					Contact c = new Contact();
					System.out.println("Enter the contact Name:");
					c.setName(scan.next());
					System.out.println("Enter the contact Email:");
					c.setEmail(scan.next());
					int countryCode;
					System.out.println("Enter the country code:");
					countryCode = scan.nextInt();
					System.out.println("Enter the contact Number:");
					c.setNumber(scan.nextLong(), countryCode);
					Methods.write(c);
					System.out.println("The Contact has been added successfully");
					break;
				case 2:
					Methods.view();
					break;
				case 3:
					System.out.println("Enter the name/email or number to search");
					String key = scan.next();
					Methods.search(key);
					break;
				case 4:
					Methods.export(fileNumber);
					fileNumber++;
					System.out.println(fileNumber);
					break;
				case 5:
					scan.close();
					System.exit(0);
				}
			}

		} catch (InputMismatchException e) {
			System.out.println("You have given an incorrect input. Please enter a valid number");
		} catch (IOException e) {
			System.out.println("The File is unreachable");
		}
	}

}
