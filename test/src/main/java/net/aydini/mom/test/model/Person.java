package net.aydini.mom.test.model;

import java.util.List;

public class Person {

	private String name;
	
	
	private String family;
	
	
	private Integer age;
	
	private List<Phone> phones;
	
	private PersonType personType;
	

	public PersonType getPersonType() {
		return personType;
	}


	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}


	public List<Phone> getPhones() {
		return phones;
	}


	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFamily() {
		return family;
	}


	public void setFamily(String family) {
		this.family = family;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
