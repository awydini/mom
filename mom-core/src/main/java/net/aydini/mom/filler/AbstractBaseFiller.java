package net.aydini.mom.filler;

import java.lang.reflect.Field;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.aydini.mom.common.exception.FillerException;
import net.aydini.mom.common.holder.MaperEntity;
import net.aydini.mom.common.service.filler.FieldFiller;
import net.aydini.mom.mapper.AbstractObjectMaper;
import net.aydini.mom.util.reflection.ReflectionUtil;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 31, 2021
 */
public abstract class AbstractBaseFiller implements FieldFiller
{

    private final static Logger log = LoggerFactory.getLogger(AbstractBaseFiller.class);

    public final <T> void fill(MaperEntity<T> maperEntity, Field field)
    {
        Optional<Object> fieldValue = getValueOfSourceField(maperEntity, field);
        if (!fieldValue.isPresent()) return;
        if (ReflectionUtil.isSimpleType(fieldValue.get().getClass())
                || ReflectionUtil.sameTypes(fieldValue.get().getClass(), field.getType()))
            SetValueToTarget(maperEntity, field, fieldValue.get());
        else SetValueToTarget(maperEntity, field, getMaper().map(fieldValue.get(), field.getType()));
    }

    protected abstract AbstractObjectMaper getMaper();

    protected abstract <T> Optional<Object> getValueOfSourceField(MaperEntity<T> maperEntity, Field targetObjectField);

    protected <T> void SetValueToTarget(MaperEntity<T> maperEntity, Field targetObjectField, Object object)
    {
        try
        {
            ReflectionUtil.setFieldValueToObject(targetObjectField, maperEntity.getTarget(), object);
        }
        catch (IllegalArgumentException e)
        {
            log.error("cant get value of {} from  ", targetObjectField.getName(), maperEntity.getSource());
            throw new FillerException(e.getMessage(), e);
        }

    }

}
