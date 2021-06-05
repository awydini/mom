package net.aydini.mom.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.aydini.mom.model.PersonDto;
import net.aydini.mom.model.SuperUser;
import net.aydini.mom.model.User;

public class MegaObjectMapperTests {
	
	private MegaObjectMaper objectMaper;
    private SuperUser user;

    @BeforeEach
    public void init()
    {
        objectMaper = new MegaObjectMaper();
        user = new SuperUser("aydin", "123", LocalDate.now());
        PersonDto person = new PersonDto();
        person.setAge(18);
        person.setName("joe");
        user.setPerson(person);
    }

    @Test
    public void objectMaperTestWithDifferentPersonType()
    {

        User superUser = objectMaper.map(user, User.class);

        assertEquals(user.getUsername(), superUser.getUsername());
        assertEquals("map"+user.getPassword(), superUser.getPassword());
        assertEquals(user.getRegisterDate().plusDays(5), superUser.getRegisterDate());
        assertNotNull(user.getPerson());
        assertEquals(user.getPerson().getName(), superUser.getPerson().getName());
        assertEquals(user.getPerson().getAge(), superUser.getPerson().getAge());
    	
    }
    
    
	

}
