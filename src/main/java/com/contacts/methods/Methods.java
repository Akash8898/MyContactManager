package com.contacts.methods;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.contacts.contact.Contact;
import com.contacts.sort.SortByName;

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
		fr.read(target);
		fr.close();
		String s = new String();
		String str = new String(target);
		String[] array = str.split("\n");
		List<String> list = Arrays.asList(array);
		Collections.sort(list,new SortByName());
		Iterator<String> i = list.listIterator();
		FileWriter fw = new FileWriter(file);
		while(i.hasNext())
		{
			s+=i.next() + "\n";
		}
		fw.write(s);
		fw.close();
//		Files.write(Paths.get(file.getName()), list, Charset.defaultCharset());
	}

	public static void view() throws IOException {
		FileReader fr = new FileReader(file);
		if(file.length()==0)
			System.out.println("There are no contacts to display");
		else {
			char[] target = new char[(int) file.length()];
			fr.read(target);
			fr.close();
			String str = new String(target);
			String[] arr = str.split("\n");
			for (String s : arr)
				System.out.println(s);
		}
	}



	public static void search(String key) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader(file);
		char[] target = new char[(int) file.length()];
		fr.read(target);
		fr.close();
		String str = new String(target);
		List<String> list = Arrays.asList(str.split("\n"));
		List<String> oplist = list.parallelStream().filter(s -> s.trim().contains(key))
				.collect(Collectors.toList());
		for(String s: oplist)
			System.out.println(s);
		if(oplist.isEmpty())
			System.out.println("No match found");
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
