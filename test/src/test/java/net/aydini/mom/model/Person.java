package net.aydini.mom.model;

import net.aydini.mom.test.model.PersonType;

public class Person
{

    private String name;
    private Integer age;
    private PersonType personType;
    
    
    
    
    public PersonType getPersonType() {
		return personType;
	}
	public void setPersonType(PersonType personType) {
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
    public Person(String name, Integer age)
    {
        super();
        this.name = name;
        this.age = age;
    }
    public Person()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
}
