package net.aydini.mom.util.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import net.jodah.expiringmap.ExpiringMap;


/**
 * 
 * @author aydin
 *
 */
public class FieldWarehouse
{
	
	
	
	private final static Map<String, Set<Field>> classFields;
	
	
	private final static Map<Map<String, String>, Set<Field>> annotatedClassFieldsMap;
	
	
	static 
	{
		classFields = ExpiringMap.builder()
				  .maxSize(127)
				  .expiration(60, TimeUnit.MINUTES)
				  .build();
		
		
		annotatedClassFieldsMap = ExpiringMap.builder()
				  .maxSize(127)
				  .expiration(60, TimeUnit.MINUTES)
				  .build();
	}
	



    private FieldWarehouse()
    {};


    public static Set<Field> getClassFields(Class<?> clazz)
    {
        addClassFields(clazz);
        return classFields.get(clazz.getName());
    }

    private static void addClassFields(Class<?> clazz)
    {
        if (!classFields.containsKey(clazz.getName()))
            classFields.put(clazz.getName(), ReflectionUtil.getClassFields(clazz));
    }

    public static Set<Field> getAnnotatedClassFields(Class<?> clazz, Class<? extends Annotation> annotation)
    {
        addAnnotatedClassFields(clazz, annotation);
        Map<String, String> map = new HashMap<String, String>();
        map.put(clazz.getName(), annotation.getName());
        return annotatedClassFieldsMap.get(map);
    }

    private static void addAnnotatedClassFields(Class<?> clazz, Class<? extends Annotation> annotation)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put(clazz.getName(), annotation.getName());

        if (!annotatedClassFieldsMap.containsKey(map))
        {
            annotatedClassFieldsMap.put(map, ReflectionUtil.getAnnotatedClassFields(clazz, annotation));
        }
    }

}
