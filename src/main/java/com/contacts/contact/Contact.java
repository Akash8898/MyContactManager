package com.contacts.contact;

import java.util.Comparator;

public class Contact {

	public String name, email, number;

	public Contact() {

	}

	public Contact(String name, String email, String number) {

		this.name = name;
		this.email = email;
		this.number = number;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return name + "-" + email + "-" + number + "\n";
	}

}

class SortByName implements Comparator<String> {

	@Override
	public int compare(String a, String b) {
		// TODO Auto-generated method stub
		return a.compareTo(b);

	}

}
