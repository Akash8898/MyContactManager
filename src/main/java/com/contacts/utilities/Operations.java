package com.contacts.utilities;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.contacts.View.Contact;

public class Operations {

	public void mainProcess(Utilities utils) {

		String choice = "";
		int fileNumber = 1;

		Scanner scan = new Scanner(System.in);
		while (true) {
			try {

				System.out.println("Enter a choice:");
				System.out.println("1.Create new Contact\t2.View\t3.Search\t4.Export\t 5.Delete\t6.Exit");
				choice = scan.next();
				switch (choice) {
				case "1":
					createNewContact(utils, scan);
					break;
				case "2":
					utils.fileView();
					break;
				case "3":
					System.out.println("Enter the name/email or number to search");
					String key = scan.next();
					List<String> list = utils.fileSearch(key);
					if (!list.isEmpty())
						list.forEach(System.out::println);

					break;
				case "4":
					utils.fileExport(fileNumber);
					fileNumber++;
					break;
				case "5":
					System.out.println("Enter the name/email of number of the contact to be deleted:");
					utils.fileDelete(utils.fileSearch(scan.next()));
					break;
				case "6":
					scan.close();
					System.exit(0);
				default:
					System.out.println("Invalid Operation");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("You have given an incorrect input. Please enter a valid number");

			} catch (IOException e) {
				System.out.println("The File is unreachable");

			}
		}

	}

	public void createNewContact(Utilities utils, Scanner scan) throws IOException {
		Contact c = new Contact();
		System.out.println("Enter the contact Name:");
		c.setName(scan.next());
		System.out.println("Enter the contact Email:");
		c.setEmail(scan.next());
		int countryCode;
		System.out.println("Enter the country code:");
		countryCode = scan.nextInt();
		System.out.println("Enter the contact Number:");
		String res = utils.formatNumber(scan.nextLong(), countryCode);
		c.setNumber(res);
		System.out.println(res);
		utils.fileWrite(c);
	}

}
