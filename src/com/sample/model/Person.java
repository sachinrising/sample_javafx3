package com.sample.model;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;

public class Person {
	private final SimpleStringProperty firstName = new SimpleStringProperty("");
	private final SimpleStringProperty lastName = new SimpleStringProperty("");
	private final SimpleStringProperty email = new SimpleStringProperty("");

	public Person() {
		this("", "", "");
	}
	
	public static ArrayList<Person> createInstance() {
		ArrayList<Person> persons = new ArrayList<>();
		Person person = new Person("Ajay", "Mishra", "Ajas@gma.com");
		Person person2 = new Person("Sandeep", "Jain", "sandeep@gma.com");

		persons.add(person);
		persons.add(person2);
		return persons;
	}

	public Person(String firstName, String lastName, String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
	}

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String fName) {
		firstName.set(fName);
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String fName) {
		lastName.set(fName);
	}

	public String getEmail() {
		return email.get();
	}

	public void setEmail(String fName) {
		email.set(fName);
	}
}
