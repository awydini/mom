package net.aydini.mom.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.aydini.mom.model.Person;
import net.aydini.mom.model.SuperUser;
import net.aydini.mom.model.User;
import net.aydini.mom.model.UserDto;

public class SimpleObjectMaperTests
{

    private SimpleObjectMaper objectMaper;
    private UserDto userDto;
    
    @BeforeEach
    public void init()
    {
        objectMaper = new SimpleObjectMaper();
        userDto = new UserDto("aydin","123",LocalDate.now());
        Person person = new Person();
        person.setAge(18);
        person.setName("joe");
        userDto.setPerson(person);
    }
    
    
    @Test
    public void objectMaperTest()
    {
        User user = objectMaper.map(userDto, User.class);
        assertEquals(userDto.getUsername(), user.getUsername());
        assertEquals(userDto.getPassword(), user.getPassword());
        assertEquals(userDto.getRegisterDate(), user.getRegisterDate());
        assertNotNull(user.getPerson());
        assertEquals(userDto.getPerson().getName(), user.getPerson().getName());
        assertEquals(userDto.getPerson().getAge(), user.getPerson().getAge());
        
    }

    
    
    @Test
    public void objectMaperTestWithDifferentPersonType()
    {
        SuperUser user = objectMaper.map(userDto, SuperUser.class);
        assertEquals(userDto.getUsername(), user.getUsername());
        assertEquals(userDto.getPassword(), user.getPassword());
        assertEquals(userDto.getRegisterDate(), user.getRegisterDate());
        assertNotNull(user.getPerson());
        assertEquals(userDto.getPerson().getName(), user.getPerson().getName());
        assertEquals(userDto.getPerson().getAge(), user.getPerson().getAge());
        
    }
}
