package com.contacts.Controller;

import java.io.IOException;

import com.contacts.interfaces.Utilities;
import com.contacts.utilities.FileUtilities;
import com.contacts.utilities.Operations;

public class Main {

	public static void main(String[] args) throws IOException {

		Utilities utils = new FileUtilities();
		Operations op = new Operations();
		op.mainProcess(utils);

	}

}
