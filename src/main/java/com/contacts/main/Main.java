package com.contacts.main;

import java.io.IOException;

import java.util.List;
import java.util.Scanner;

import com.contacts.contact.Contact;
import com.contacts.utilities.FileUtilities;
import com.contacts.utilities.Operations;
import com.contacts.utilities.Utilities;

public class Main {

	public static void main(String[] args) throws IOException {

		Utilities utils = new FileUtilities();
		Operations op = new Operations();
		op.mainProcess(utils);

	}

}
