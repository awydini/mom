package net.aydini.mom.mapper;

import java.lang.reflect.Field;
import java.util.Set;

import net.aydini.mom.common.holder.MaperEntity;
import net.aydini.mom.common.service.maper.ObjectMaper;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 29, 2021
 */
public abstract class AbstractObjectMaper implements ObjectMaper 
{

    @Override
    public final <T> T map(Object source, Class<T> targetClass)
    {
        return map(new MaperEntity<T>(source, targetClass));
    }

    protected  <T> T map(final MaperEntity<T> maperEntity)
    {
        getMapingFields(maperEntity.getTargetClass()).parallelStream().forEach(item->gettFieldFiller().fill(maperEntity, item));
        return maperEntity.getTarget();
    }
    
    protected abstract <T> Set<Field> getMapingFields(Class<T> targetClass);

}
