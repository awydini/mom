package net.aydini.mom.filler;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.aydini.mom.common.service.filler.FieldFiller;
import net.aydini.mom.model.User;
import net.aydini.mom.model.UserDto;
import net.aydini.mom.util.reflection.ReflectionUtil;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Apr 10, 2021
 */
public class FillerFactoryTests
{

    @Test
    public void shouldCreateAnnotatedFieldFiller()
    {
        FieldFiller fieldFiller = FillerFactory.getFieldFiller(ReflectionUtil.findClassFieldByFieldName(User.class, "username"), null);
        assertNotNull(fieldFiller);
        assertTrue(fieldFiller instanceof AnnotatedFieldFiller);
        
    }
    
    
    @Test
    public void shouldCreateSimpleFieldFiller()
    {
        FieldFiller fieldFiller = FillerFactory.getFieldFiller(ReflectionUtil.findClassFieldByFieldName(UserDto.class, "username"), null);
        assertNotNull(fieldFiller);
        assertTrue(fieldFiller instanceof SimpleFieldFiller);
        
    }
}
