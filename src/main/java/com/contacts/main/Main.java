package com.contacts.main;

import static com.contacts.utilities.Utils.*;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.contacts.contact.Contact;
import com.contacts.utilities.Utils;

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
					String res = Utils.formatNumber(scan.nextLong(), countryCode);
					c.setNumber(res);
					System.out.println(res);
					write(c);
					break;
				case 2:
					view();
					break;
				case 3:
					System.out.println("Enter the name/email or number to search");
					String key = scan.next();
					search(key);
					break;
				case 4:
					export(fileNumber);
					fileNumber++;
					break;
				case 5:
					scan.close();
					System.exit(0);
				case 6:
					sort();
					break;
				default:
					System.out.println("Invalid Operation");
					break;
				}
			}

		} catch (InputMismatchException e) {
			System.out.println("You have given an incorrect input. Please enter a valid number");
			main(args);
		} catch (IOException e) {
			System.out.println("The File is unreachable");
			main(args);
		}
	}

}
