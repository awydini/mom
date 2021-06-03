package net.aydini.mom.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.aydini.mom.model.Person;
import net.aydini.mom.model.SuperUser;
import net.aydini.mom.model.User;

public class SimpleObjectMaperTests
{

    private SimpleObjectMaper objectMaper;
    private User user;

    @BeforeEach
    public void init()
    {
        objectMaper = new SimpleObjectMaper();
        user = new User("aydin", "123", LocalDate.now());
        Person person = new Person();
        person.setAge(18);
        person.setName("joe");
        user.setPerson(person);
    }

    @Test
    public void objectMaperTestWithDifferentPersonType()
    {

        SuperUser superUser = objectMaper.map(user, SuperUser.class);

        assertEquals(user.getUsername(), superUser.getUsername());
        assertEquals(user.getPassword(), superUser.getPassword());
        assertEquals(user.getRegisterDate(), superUser.getRegisterDate());
        assertNotNull(user.getPerson());
        assertEquals(user.getPerson().getName(), superUser.getPerson().getName());
        assertEquals(user.getPerson().getAge(), superUser.getPerson().getAge());

    }
}
