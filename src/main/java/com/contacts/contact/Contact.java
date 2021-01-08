package com.contacts.contact;


import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class Contact {

	public String name, email, number;

	public Contact() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(long number, int code) {
		PhoneNumber num = new PhoneNumber();
		PhoneNumberUtil util = PhoneNumberUtil.getInstance();
		PhoneNumberFormat numberFormat = PhoneNumberFormat.INTERNATIONAL;
		num.setCountryCode(code);
		num.setNationalNumber(number);
		String str = util.format(num, numberFormat);
		System.out.println(str);
		this.number = str;
	}

	@Override
	public String toString() {
		return name + "," + email + "," + number + ";";
	}

}
