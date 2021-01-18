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
import java.util.stream.Collectors;
import org.apache.commons.validator.routines.EmailValidator;
import com.contacts.contact.Contact;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class FileUtilities implements Utilities {

	private File file = new File("PhoneBook.txt");
	private Path path = Paths.get("PhoneBook.txt");

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
		FileUtilities u = new FileUtilities();
		List<String> list = Files.readAllLines(u.path);
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
		System.out.println("The contacst has been exported to the local directory:" + exportFile.getAbsolutePath());

	}

}
