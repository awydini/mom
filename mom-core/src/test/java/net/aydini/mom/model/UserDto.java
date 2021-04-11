package net.aydini.mom.model;

import java.time.LocalDate;

/**
 * 
 * @author aydin
 *
 */
public class UserDto
{
    
    
    private String username;
    private String password;
    private LocalDate registerDate;
    private boolean active;
    private Person person;
    
    
    
    
    
    public boolean isActive()
    {
        return active;
    }
    public void setActive(boolean active)
    {
        this.active = active;
    }
    public Person getPerson()
    {
        return person;
    }
    public void setPerson(Person person)
    {
        this.person = person;
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
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public UserDto(String username, String password, LocalDate registerDate)
    {
        super();
        this.username = username;
        this.password = password;
        this.registerDate = registerDate;
    }
    public UserDto()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

}
