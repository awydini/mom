package net.aydini.mom.filler;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import net.aydini.mom.common.exception.MomBaseException;
import net.aydini.mom.common.holder.MaperEntity;
import net.aydini.mom.common.service.filler.FieldFiller;
import net.aydini.mom.common.service.maper.ObjectMaper;
import net.aydini.mom.mapper.CollectionMapper;
import net.aydini.mom.util.reflection.ReflectionUtil;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 31, 2021
 */
public abstract class AbstractBaseFiller implements FieldFiller {


	private final ObjectMaper objectMapper;

	AbstractBaseFiller(ObjectMaper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@SuppressWarnings({ "unchecked" })
	public final <T> void fill(MaperEntity<T> maperEntity, Field field) {
		Optional<Object> fieldValue = null;

		try 
		{
			fieldValue = getValueOfSourceField(maperEntity, field);
		} catch (Exception e) {
			onGetValueError(e, field);
		}
		try
		{
		if (!fieldValue.isPresent())
			return;
		else if (ReflectionUtil.isSimpleType(fieldValue.get().getClass())) 
			SetValueToTarget(maperEntity, field, fieldValue.get());
		else if(ReflectionUtil.isCollection(fieldValue.get().getClass()) && ReflectionUtil.isCollection(field.getType()))
			 SetValueToTarget(maperEntity, field, new CollectionMapper(objectMapper).map(((List<Object>)fieldValue.get()).stream().map(item->(Object)item).collect(Collectors.toList()), field)); 
		else if (ReflectionUtil.sameTypes(fieldValue.get().getClass(), field.getType())) 
			SetValueToTarget(maperEntity, field, fieldValue.get());
		else
			SetValueToTarget(maperEntity, field, objectMapper.map(fieldValue.get(), field.getType()));
		}catch(Exception e)
		{
			onSetValueError(e, field, maperEntity.getTarget());
		}
	}

	protected abstract void onSetValueError(Exception exception, Field targetObjectField, Object object)
			throws MomBaseException;

	protected abstract void onGetValueError(Exception exception, Field field) throws MomBaseException;

	protected abstract <T> Optional<Object> getValueOfSourceField(MaperEntity<T> maperEntity, Field targetObjectField);

	protected <T> void SetValueToTarget(MaperEntity<T> maperEntity, Field targetObjectField, Object object) {
		try {
			ReflectionUtil.setFieldValueToObject(targetObjectField, maperEntity.getTarget(), object);
		} catch (Exception e) {
			onSetValueError(e, targetObjectField, object);
		}

	}

}
