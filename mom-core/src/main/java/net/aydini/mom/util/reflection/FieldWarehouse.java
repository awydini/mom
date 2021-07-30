package net.aydini.mom.util.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * 
 * @author aydin
 *
 */
public class FieldWarehouse {

	private final Map<String, Set<Field>> classFields = new WeakHashMap<>();

	private final Map<Map<String, String>, Set<Field>> annotatedClassFieldsMap = new WeakHashMap<>();

	public Set<Field> getClassFields(Class<?> clazz) {
		if (!classFields.containsKey(clazz.getName()))
			addClassFields(clazz);
		return classFields.get(clazz.getName());
	}

	private synchronized void addClassFields(Class<?> clazz) {
		classFields.put(clazz.getName(), ReflectionUtil.getClassFields(clazz));
	}

	public Set<Field> getAnnotatedClassFields(Class<?> clazz, Class<? extends Annotation> annotation) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(clazz.getName(), annotation.getName());
		if (!annotatedClassFieldsMap.containsKey(map))
			addAnnotatedClassFields(clazz, annotation);
		return annotatedClassFieldsMap.get(map);
	}

	private synchronized void addAnnotatedClassFields(Class<?> clazz, Class<? extends Annotation> annotation) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(clazz.getName(), annotation.getName());

		annotatedClassFieldsMap.put(map, ReflectionUtil.getAnnotatedClassFields(clazz, annotation));
	}

}
