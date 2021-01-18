package com.contacts.utilities;

import java.io.IOException;
import java.util.List;

import com.contacts.contact.Contact;

public interface Utilities {

	void fileWrite(Contact contact) throws IOException;

	String formatNumber(long number, int code);

	void fileView() throws IOException;

	List<String> fileSearch(String key) throws IOException;

	void fileExport(int fileNumber) throws IOException;

}