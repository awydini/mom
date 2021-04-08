package net.aydini.mom.filler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.aydini.mom.common.exception.FillerException;
import net.aydini.mom.common.holder.MaperEntity;
import net.aydini.mom.mapper.AbstractObjectMaper;
import net.aydini.mom.util.reflection.ReflectionUtil;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Apr 7, 2021
 */
public class SimpleFieldFiller extends AbstractBaseFiller
{

    private final static Logger log = LoggerFactory.getLogger(SimpleFieldFiller.class);

    @Override
    protected <T> Optional<Object> getValueOfSourceField(MaperEntity<T> maperEntity, Field field)
    {
        try
        {
            return Optional.ofNullable(ReflectionUtil.getFieldValueFromObject(field, maperEntity.getSource()));
        }
        catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e)
        {
            log.error("cant get value of {} from  ", field.getName(), maperEntity.getSource());
            throw new FillerException(e.getMessage(), e);
        }
    }

    @Override
    protected AbstractObjectMaper getMaper()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
