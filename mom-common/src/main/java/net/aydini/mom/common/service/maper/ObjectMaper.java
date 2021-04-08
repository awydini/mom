package net.aydini.mom.common.service.maper;

import net.aydini.mom.common.service.filler.Fillable;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 29, 2021
 */
public interface ObjectMaper extends Fillable
{
     <T> T map(Object source, Class<T> targetClass);
    
}
