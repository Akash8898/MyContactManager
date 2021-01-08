package com.test.format;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PhoneNumber number = new PhoneNumber();
		PhoneNumberUtil util = PhoneNumberUtil.getInstance();
		PhoneNumberFormat numberFormat = PhoneNumberFormat.INTERNATIONAL;
		number.setCountryCode(1);
		number.setNationalNumber(8754064243l);
		System.out.println(number.toString());
		String str = util.format(number, numberFormat);
		System.out.println(str);

}
}