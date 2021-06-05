package net.aydini.mom.filler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.aydini.mom.common.holder.MaperEntity;
import net.aydini.mom.common.service.filler.FieldFiller;
import net.aydini.mom.model.Person;
import net.aydini.mom.model.User;
import net.aydini.mom.model.UserDto;
import net.aydini.mom.util.reflection.ReflectionUtil;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Apr 7, 2021
 */
public class AnnotatedFieldFillerTests
{

    private FieldFiller filler;
    private MaperEntity<User> maperEntity;
    
    @BeforeEach
    public void init()
    {
        filler = new AnnotatedFieldFiller(null);
        maperEntity = new MaperEntity<>(new UserDto("aydin","123",LocalDate.now()), User.class);
    }
    
    @Test
    public void fillByFieldName()
    {
        filler.fill(maperEntity, ReflectionUtil.findClassFieldByFieldName(User.class, "username"));
        assertNotNull(maperEntity.getTarget());
        assertEquals(( (UserDto) maperEntity.getSource()).getUsername(), ((User)maperEntity.getTarget()).getUsername());
    }
    
    
    @Test
    public void fillWithMapperClass()
    {
        filler.fill(maperEntity, ReflectionUtil.findClassFieldByFieldName(User.class, "password"));
        assertNotNull(maperEntity.getTarget());
        assertEquals( "map"+( (UserDto) maperEntity.getSource()).getPassword(), ((User)maperEntity.getTarget()).getPassword());
    }
    
    

    @Test
    public void fillCompositModelWithSameType()
    {
        Person person = new Person("jack",15);
        ((UserDto)maperEntity.getSource()).setPerson(person);
        filler.fill(maperEntity, ReflectionUtil.findClassFieldByFieldName(User.class, "person"));
        assertNotNull(maperEntity.getTarget());
        assertNotNull( ((User)maperEntity.getTarget()).getPerson());
        assertEquals( ( (UserDto) maperEntity.getSource()).getPerson().getAge(), ((User)maperEntity.getTarget()).getPerson().getAge());
    }
    

    

}
