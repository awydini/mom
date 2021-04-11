package net.aydini.mom.mapper;

import java.lang.reflect.Field;
import java.util.Set;

import net.aydini.mom.util.reflection.FieldWarehouse;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Apr 10, 2021
 */
public class MegaObjectMaper extends AbstractObjectMaper
{
    @Override
    protected <T> Set<Field> getMapingFields(Class<T> targetClass)
    {
        return FieldWarehouse.getClassFields(targetClass);
    }

}
