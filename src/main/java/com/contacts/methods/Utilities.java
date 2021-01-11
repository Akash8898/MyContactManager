package com.contacts.methods;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.contacts.contact.Contact;

public class Utilities {

	private static File file = new File("PhoneBook.txt");
	private static Path path = Paths.get("PhoneBook.txt");

	public static void write(Contact contact) throws IOException {
		FileWriter fr = new FileWriter(file, true);
		fr.append(contact.toString().toLowerCase());
		fr.close();
		sort();
	}

	public static void sort() throws IOException {
		List<String> list = Files.readAllLines(path);
		Collections.sort(list, new SortByName());
		Files.write(path, list, Charset.defaultCharset());
	}

	public static void view() throws IOException {
		if (file.length() == 0)
			System.out.println("There are no contacts to display");
		else {
			List<String> list = Files.readAllLines(path);
			list.forEach(s -> System.out.println(s));
			System.out.println();
		}
	}

	public static void search(String key) throws IOException {
		List<String> list = Files.readAllLines(path);
		List<String> oplist = list.parallelStream().filter(s -> s.trim().contains(key)).collect(Collectors.toList());
		for (String s : oplist)
			System.out.println(s);
		if (oplist.isEmpty())
			System.out.println("No match found");
	}

	public static void export(int fileNumber) throws IOException {
		File exportFile = new File("Contacts" + fileNumber + ".txt");
		exportFile.createNewFile();
		fileNumber++;

		List<String> list = Files.readAllLines(path);
		Files.write(Paths.get(exportFile.getName()), list, Charset.defaultCharset());
		System.out.println("The contacst has been exported to the local directory:" + exportFile.getAbsolutePath());

	}

}
