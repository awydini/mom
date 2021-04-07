package net.aydini.mom.filler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.aydini.mom.common.exception.FillerException;
import net.aydini.mom.common.holder.MaperEntity;
import net.aydini.mom.util.reflection.ReflectionUtil;

public class SimpleFieldFiller extends AbstractBaseFiller
{

    private final static Logger log = LoggerFactory.getLogger(SimpleFieldFiller.class);

    @Override
    protected <T> Object getValueOfSourceField(MaperEntity<T> maperEntity, Field field)
    {
        try
        {
            return ReflectionUtil.getFieldValueFromObject(field, maperEntity.getSource());
        }
        catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e)
        {
            log.error("cant get value of {} from  ", field.getName(), maperEntity.getSource());
            throw new FillerException(e.getMessage(),e);
        }
    }

    @Override
    protected <T> void SetValueToTarget(MaperEntity<T> maperEntity, Field targetObjectField, Object object)
    {
        try
        {
             ReflectionUtil.setFieldValueToObject(targetObjectField, maperEntity.getTarget(), object);
        }
        catch (IllegalArgumentException  e)
        {
            log.error("cant get value of {} from  ", targetObjectField.getName(), maperEntity.getSource());
            throw new FillerException(e.getMessage(),e);
        }

    }


}
