package net.aydini.mom.model;

import net.aydini.mom.test.model.PersonTypeEunm;

public class PersonDto
{

    private String name;
    private Integer age;
    private PersonTypeEunm personType;
    
    
    
    public PersonTypeEunm getPersonType() {
		return personType;
	}
	public void setPersonType(PersonTypeEunm personType) {
		this.personType = personType;
	}
	public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public Integer getAge()
    {
        return age;
    }
    public void setAge(Integer age)
    {
        this.age = age;
    }
    public PersonDto(String name, Integer age)
    {
        super();
        this.name = name;
        this.age = age;
    }
    public PersonDto()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
}
