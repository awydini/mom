package net.aydini.mom.filler;

import java.lang.reflect.Field;

import net.aydini.mom.common.annotation.MapedField;
import net.aydini.mom.common.service.filler.FieldFiller;
import net.aydini.mom.common.service.maper.ConditionalMaper;
import net.aydini.mom.common.service.maper.ObjectMaper;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Apr 10, 2021
 */
public class FillerFactory
{

    public static FieldFiller getFieldFiller(Field field, ObjectMaper objectMaper)
    {
        if (field.isAnnotationPresent(MapedField.class)) return new AnnotatedFieldFiller(objectMaper);
        return new SimpleFieldFiller(objectMaper);
    }

    public static FieldFiller getFieldFiller(ConditionalMaper conditionalMaper)
    {
        return new ConditionalFieldFiller(conditionalMaper);
    }

}
