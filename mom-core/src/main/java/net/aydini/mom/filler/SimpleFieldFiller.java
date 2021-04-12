package net.aydini.mom.filler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.aydini.mom.common.exception.FillerException;
import net.aydini.mom.common.holder.ConditionalMaperEntity;
import net.aydini.mom.common.service.maper.ObjectMaper;
import net.aydini.mom.util.reflection.ReflectionUtil;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Apr 7, 2021
 */
public class SimpleFieldFiller extends AbstractBaseFiller
{

    SimpleFieldFiller(ObjectMaper objectMapper)
    {
        super(objectMapper);
    }

    private final static Logger log = LoggerFactory.getLogger(SimpleFieldFiller.class);

    @Override
    protected <T,C> Optional<Object> getValueOfSourceField(ConditionalMaperEntity<T,C> maperEntity, Field field)
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


}
