package net.aydini.mom.filler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.aydini.mom.common.domain.Condition;
import net.aydini.mom.common.holder.ConditionalMaperEntity;
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
    private ConditionalMaperEntity<User,Condition<Object>> maperEntity;
    
    @BeforeEach
    public void init()
    {
        filler = new AnnotatedFieldFiller(null);
        maperEntity = new ConditionalMaperEntity<>(new UserDto("aydin","123",LocalDate.now()), User.class,null);
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
    public void fillWithCustomMapper()
    {
        filler.fill(maperEntity, ReflectionUtil.findClassFieldByFieldName(User.class, "registerDate"));
        assertNotNull(maperEntity.getTarget());
        assertEquals( ( (UserDto) maperEntity.getSource()).getRegisterDate().plusDays(5), ((User)maperEntity.getTarget()).getRegisterDate());
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
