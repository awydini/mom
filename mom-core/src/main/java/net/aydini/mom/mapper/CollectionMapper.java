package net.aydini.mom.mapper;

import java.lang.reflect.Field;
import java.util.Collection;

import net.aydini.mom.common.service.maper.ObjectMaper;
import net.aydini.mom.util.facroty.CollectionFactory;
import net.aydini.mom.util.reflection.ReflectionUtil;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
public class CollectionMapper {

	private final ObjectMaper objectMapper;

	public CollectionMapper(ObjectMaper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@SuppressWarnings("unchecked")
	public <T> Collection<?> map(Collection<Object> input, Field collectionField) {
		Class<T> genericType = ReflectionUtil.getGenericType(collectionField);
		Collection<T> targetCollection = (Collection<T>) CollectionFactory.createCollection(collectionField.getType());
		input.parallelStream().map(item -> objectMapper.map(item, genericType)).forEach(item->targetCollection.add(item));
		return targetCollection;
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> Collection<?> mapOrdered(Collection<Object> input, Field collectionField) {
		Class<T> genericType = ReflectionUtil.getGenericType(collectionField);
		Collection<T> targetCollection = (Collection<T>) CollectionFactory.createCollection(collectionField.getType());
		input.parallelStream().map(item -> objectMapper.map(item, genericType)).forEachOrdered(item->targetCollection.add(item));
		return targetCollection;
	}

}
