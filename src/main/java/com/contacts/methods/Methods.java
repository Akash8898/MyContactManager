package com.contacts.methods;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.contacts.contact.Contact;

public class Methods {

	private static File file = new File("PhoneBook.txt");

	public static void write(Contact contact) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fr = new FileWriter(file, true);
		fr.append(contact.toString().toLowerCase());
		fr.close();
		sort();
	}

	public static void sort() throws IOException {
		FileReader fr = new FileReader(file);
		char[] target = new char[(int) file.length()];
		String appendString = new String();
		fr.read(target);
		fr.close();
		String str = new String(target);
		String[] arr = str.split(";");
		Arrays.sort(arr);
		for (String s : arr)
			if (appendString.isEmpty())
				appendString = s + ";";
			else
				appendString += s + ";";
		FileWriter fw = new FileWriter(file);
		fw.write(appendString);
		fw.close();
	}

	public static void view() throws IOException {
		FileReader fr = new FileReader(file);
		char[] target = new char[(int) file.length()];
		fr.read(target);
		fr.close();
		String str = new String(target);
		String[] arr = str.split(";");
		for (String s : arr)
			System.out.println(s);
	}

	public static void search(String key) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader(file);
		int count = 0;
		char[] target = new char[(int) file.length()];
		fr.read(target);
		fr.close();
		String str = new String(target);
		String[] arr = str.split(";");
		for (String s : arr)
			if (s.contains(key)) // Tried using Binary search.But only one match is returned
			{
				System.out.println(s);
				count++;
			}

		if (count == 0)
			System.out.println("No matching contact");
	}

	public static void export(int fileNumber) throws IOException {
		// TODO Auto-generated method stub
		File exportFile = new File("Contacts" + fileNumber + ".txt");
		exportFile.createNewFile();
		fileNumber++;
		FileReader fr = new FileReader(file);
		char[] target = new char[(int) file.length()];
		fr.read(target);
		fr.close();
		String str = new String(target);
		FileWriter fw = new FileWriter(exportFile);
		fw.write(str);
		fw.close();
		System.out.println("The contacst has been exported to the local directory:" + exportFile.getAbsolutePath());
	}

}
