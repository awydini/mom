package net.aydini.mom.model;

import java.time.LocalDate;

import net.aydini.mom.common.annotation.MapedField;
import net.aydini.mom.mapper.CustomDateMaper;
import net.aydini.mom.mapper.PasswordMaper;

/**
 * 
 * @author aydin
 *
 */
public class User
{
    
    @MapedField(fieldName = "username")
    private String username;
    
    @MapedField(fieldName = "password" ,maper = PasswordMaper.class)
    private String password;
    
    @MapedField(fieldName = "registerDate" ,custom = true,maper = CustomDateMaper.class)
    private LocalDate registerDate;
    
    @MapedField(fieldName = "person" )
    private Person person;
    
    private boolean active;
    
    

    public boolean isActive()
    {
        return active;
    }
    public void setActive(boolean active)
    {
        this.active = active;
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
    
    
    public Person getPerson()
    {
        return person;
    }
    public void setPerson(Person person)
    {
        this.person = person;
    }
    public User(String username, String password, LocalDate registerDate)
    {
        super();
        this.username = username;
        this.password = password;
        this.registerDate = registerDate;
    }
    public User()
    {
        super();
        // TODO Auto-generated constructor stub
    }
}
