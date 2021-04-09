package net.aydini.mom.filler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.aydini.mom.common.holder.MaperEntity;
import net.aydini.mom.mapper.SimpleObjectMaper;
import net.aydini.mom.model.User;
import net.aydini.mom.model.UserDto;
import net.aydini.mom.util.reflection.ReflectionUtil;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Apr 7, 2021
 */
public class SimpleFillerTests
{

    private AbstractBaseFiller filler;
    private MaperEntity<User> maperEntity;
    
    @BeforeEach
    public void init()
    {
        filler = new SimpleFieldFiller(new SimpleObjectMaper());
        maperEntity = new MaperEntity<>(new UserDto("aydin","123",LocalDate.now()), User.class);
    }
    
    @Test
    public void fillStringFieldTest()
    {
        filler.fill(maperEntity, ReflectionUtil.findClassFieldByFieldName(User.class, "username"));
        assertNotNull(maperEntity.getTarget());
        assertEquals(( (UserDto) maperEntity.getSource()).getUsername(), ((User)maperEntity.getTarget()).getUsername());
    }
    
    
    @Test
    public void fillDateTest()
    {
        filler.fill(maperEntity, ReflectionUtil.findClassFieldByFieldName(User.class, "registerDate"));
        assertNotNull(maperEntity.getTarget());
        assertEquals(( (UserDto) maperEntity.getSource()).getRegisterDate(), ((User)maperEntity.getTarget()).getRegisterDate());
    }
}
