package net.aydini.mom.model;

import java.util.Date;

/**
 * 
 * @author aydin
 *
 */
public class UserDto
{
    
    
    private String username;
    private String password;
    private Date registerDate;
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public Date getRegisterDate()
    {
        return registerDate;
    }
    public void setRegisterDate(Date registerDate)
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
    public UserDto(String username, String password, Date registerDate)
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
