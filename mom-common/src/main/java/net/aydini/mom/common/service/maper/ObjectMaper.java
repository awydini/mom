package net.aydini.mom.common.service.maper;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 29, 2021
 */
public interface ObjectMaper 
{
     <T> T map(Object source, Class<T> targetClass);
    
}
