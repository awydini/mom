package net.aydini.mom.util.reflection;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.stream.Stream;

import net.aydini.mom.common.exception.MomBaseException;


/** utility class for finding getter(reader) and setter(writer) methods of a class
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 27, 2021
 */
public final class RWProperty
{

    public static Optional<Method> getReaderMethod(Class<?> clazz , Field field)
    {
        String readerMethodName = RWMethodName.createReaderMethodName(field);
        return Stream.of(getPropertyDescriptors(clazz)).parallel().filter(item->item.getReadMethod()!= null && item.getReadMethod().getName().equals(readerMethodName)).map(item->item.getReadMethod()).findAny();
    }
    
    public static Optional<Method> getWriterMethod(Class<?> clazz , Field field)
    {
        String writerMethodName = RWMethodName.createWriterMethodName(field);
        return Stream.of(getPropertyDescriptors(clazz)).parallel().filter(item->item.getWriteMethod()!= null && item.getWriteMethod().getName().equals(writerMethodName)).map(item->item.getWriteMethod()).findAny();
        
    }
    
    
    private static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz)
    {
        try
        {
            return Introspector.getBeanInfo(clazz).getPropertyDescriptors();
        }
        catch (IntrospectionException e)
        {
            throw new MomBaseException(e.getMessage());
        }
    }
    
}
