package net.aydini.mom.model;

import java.time.LocalDate;


/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Apr 10, 2021
 */
public class SuperUser
{

    

    private String username;
    private String password;
    private LocalDate registerDate;
    
    private PersonDto person;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public LocalDate getRegisterDate()
    {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate)
    {
        this.registerDate = registerDate;
    }

    public PersonDto getPerson()
    {
        return person;
    }

    public void setPerson(PersonDto person)
    {
        this.person = person;
    }
    
    
    
    
}
