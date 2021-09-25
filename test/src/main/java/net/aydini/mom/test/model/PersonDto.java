package net.aydini.mom.test.model;

import java.util.List;

public class PersonDto {

	private String name;
	
	
	private String family;
	
	
	private Integer age;
	
	private List<PhoneDto> phones;
	
	private PersonTypeEunm personType;
	
	
	
	
	

	public PersonTypeEunm getPersonType() {
		return personType;
	}


	public void setPersonType(PersonTypeEunm personType) {
		this.personType = personType;
	}


	public List<PhoneDto> getPhones() {
		return phones;
	}


	public void setPhones(List<PhoneDto> phones) {
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
