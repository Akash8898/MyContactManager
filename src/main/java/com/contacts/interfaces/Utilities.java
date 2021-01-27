package com.contacts.interfaces;

import java.io.IOException;
import java.util.List;

import com.contacts.View.Contact;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public interface Utilities {

	void write(Contact contact) throws IOException;

	void view() throws IOException;

	List<String> search(String key) throws IOException;

	void export(int fileNumber) throws IOException;

	void delete(List<String> list) throws IOException;

	default String formatNumber(long number, int code) {
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
}