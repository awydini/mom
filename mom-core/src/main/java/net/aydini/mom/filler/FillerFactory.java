package net.aydini.mom.filler;

import java.lang.reflect.Field;

import net.aydini.mom.common.annotation.MapedField;
import net.aydini.mom.common.service.filler.FieldFiller;
import net.aydini.mom.common.service.maper.ObjectMaper;
import net.aydini.mom.mapper.SimpleObjectMaper;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Apr 10, 2021
 */
public class FillerFactory
{

    public FieldFiller getFieldFiller(Field field, ObjectMaper objectMaper)
    {
        if (field.isAnnotationPresent(MapedField.class)) return new AnnotatedFieldFiller(objectMaper);
        return new SimpleFieldFiller(objectMaper);
    }
    
    public FieldFiller getSimpleFieldFiller(SimpleObjectMaper objectMaper)
    {
    	return new SimpleFieldFiller(objectMaper);
    }

}
