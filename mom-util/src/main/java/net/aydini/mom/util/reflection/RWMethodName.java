package net.aydini.mom.util.reflection;

import java.lang.reflect.Field;

import net.aydini.mom.util.string.StringUtil;

/** utility class for creating getter/setter method name by field name
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 27, 2021
 */
public final class RWMethodName
{
    
    private final static String READER_PREFIX = "get";
    private final static String boolean_READER_PREFIX = "is";
    private final static String WRITER_PREFIX = "set";
    
    public static String createReaderMethodName(Field field)
    {
        if(field.getType().equals(boolean.class))
            return boolean_READER_PREFIX + StringUtil.toUpperFirstLetter(field.getName());
        return READER_PREFIX  + StringUtil.toUpperFirstLetter(field.getName());
    }
    
    public static String createWriterMethodName(Field field)
    {
        return WRITER_PREFIX + StringUtil.toUpperFirstLetter(field.getName());
    }
    

}
