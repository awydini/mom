package net.aydini.mom.util.facroty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import net.aydini.mom.common.exception.MomBaseException;
import net.aydini.mom.util.reflection.ReflectionUtil;

public class CollectionFactory {

	
	public static <T> Collection<T> createCollection(Class<T> collectionType)
	{
		if(collectionType == null)
			throw new MomBaseException("collection type is null");
		if(ReflectionUtil.isList(collectionType))
			return new ArrayList<T>();
		if(ReflectionUtil.isSet(collectionType))
			return new HashSet<T>();
		
		throw new MomBaseException("cant instantiate collectiion of type " + collectionType.getSimpleName());
	}
	
	
	public static Map<Object,Object> createMap(Class<?> collectionType)
	{
		if(collectionType == null)
			throw new MomBaseException("collection type is null");
		if(ReflectionUtil.isMap(collectionType))
			return new HashMap<>();
		throw new MomBaseException("cant instantiate map of type " + collectionType.getSimpleName());
	}
}
