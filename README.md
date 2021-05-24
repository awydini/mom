# MOM
Mega Object Mapper - simply convert objects

example :

    public class Person{
    private String name;
    private Integer age;
    //getters and setters
    }
    
    public class PersonDTO{
    private String name;
    private Integer age;
    //getters and setters
    }
    ---------------
    
    Person person = new SimpleObjectMaper().map(personDto,Person.class);
