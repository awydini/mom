package net.aydini.mom.filler;

import java.lang.reflect.Field;

import net.aydini.mom.common.holder.MaperEntity;
import net.aydini.mom.common.service.filler.FieldFiller;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 31, 2021
 */
public abstract class AbstractBaseFiller implements FieldFiller
{
    
    public final <T> void fill(MaperEntity<T> maperEntity , Field field)
    {
            Object fieldValue = getValueOfSourceField(maperEntity, field);
            SetValueToTarget(fieldValue);
    }
    
    protected abstract <T> Object getValueOfSourceField(MaperEntity<T> maperEntity , Field field);
    
    protected abstract void SetValueToTarget(Object object);

}
