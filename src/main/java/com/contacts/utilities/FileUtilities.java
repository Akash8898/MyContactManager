package com.contacts.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.commons.validator.routines.EmailValidator;

import com.contacts.View.Contact;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class FileUtilities implements Utilities {

	public File file = new File("PhoneBook.txt");
	public Path path = Paths.get("PhoneBook.txt");

	@Override
	public void fileWrite(Contact contact) throws IOException {
		if (!EmailValidator.getInstance().isValid(contact.getEmail()))
			System.out.println("Not a valid email. Please try again later");
		else {
			FileWriter fr = new FileWriter(file, true);
			fr.append(contact.toString().toLowerCase());
			fr.close();
			List<String> list = Files.readAllLines(path);
			Collections.sort(list, new SortByName());
			Files.write(path, list, Charset.defaultCharset());
		}

	}

	@Override
	public String formatNumber(long number, int code) {

		PhoneNumber num = new PhoneNumber();
		PhoneNumberUtil util = PhoneNumberUtil.getInstance();
		num.setCountryCode(code);
		num.setNationalNumber(number);
		String str = new String();
		if (!util.isValidNumber(num))
			return "Invalid Phone Number";
		str = util.format(num, PhoneNumberFormat.INTERNATIONAL);
		return str.toLowerCase();

	}

	@Override
	public void fileView() throws IOException {
		if (file.length() == 0)
			System.out.println("There are no contacts to display");
		else {
			List<String> list = Files.readAllLines(path);
			list.forEach(System.out::println); // Higher Order Function
			System.out.println();
		}
	}

	@Override
	public List<String> fileSearch(String key) throws IOException {
		FileUtilities utils = new FileUtilities();
		List<String> list = Files.readAllLines(utils.path);
		List<String> oplist = list.parallelStream().filter(s -> s.trim().contains(key)).collect(Collectors.toList());
//		list.parallelStream().filter(s -> s.trim().contains(key)).forEach(System.out::println);
		if (oplist.isEmpty())
			System.out.println("No match found");
		return oplist;
	}

	@Override
	public void fileExport(int fileNumber) throws IOException {
		File exportFile = new File("Contacts" + fileNumber + ".txt");
		exportFile.createNewFile();
		fileNumber++;

		List<String> list = Files.readAllLines(path);
		Files.write(Paths.get(exportFile.getName()), list, Charset.defaultCharset());
		System.out.println("The contacts has been exported to the local directory:" + exportFile.getAbsolutePath());

	}

	@Override
	public void fileDelete(List<String> list) {
		if (!list.isEmpty()) {
			Scanner scan = new Scanner(System.in);
			int i = 0;
			Map<Integer, String> map = new TreeMap<>();
			for (String s : list)
				map.put(i++, s);
			System.out.println(map);
			System.out.println("Enter the key of the Contact to be deleted");
			try {
				list.remove(scan.nextInt());
				Files.write(path, list, Charset.defaultCharset());
				System.out.println("The contact has been remove Successfully");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Invalid input key");
			} catch (IOException e) {
				System.out.println("Unreachable File");
			}
			scan.close();
		}

	}

}
