package net.aydini.mom.model;

public class PersonDto
{

    private String name;
    private Integer age;
    
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
