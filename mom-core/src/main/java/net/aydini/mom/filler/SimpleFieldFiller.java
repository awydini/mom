package net.aydini.mom.filler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import net.aydini.mom.common.exception.FillerException;
import net.aydini.mom.common.exception.MomBaseException;
import net.aydini.mom.common.holder.MaperEntity;
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


    @Override
    protected <T> Optional<Object> getValueOfSourceField(MaperEntity<T> maperEntity, Field field)
    {
        try
        {
            return Optional.ofNullable(ReflectionUtil.getFieldValueFromObject(field, maperEntity.getSource()));
        }
        catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e)
        {
            throw new FillerException(e.getMessage(), e);
        }
    }

	@Override
	protected void onSetValueError(Exception exception, Field targetObjectField, Object object)
			throws MomBaseException {
		
	}

	@Override
	protected void onGetValueError(Exception exception, Field field) throws MomBaseException {
		
	}



}
