package net.aydini.mom.mapper;

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

    protected abstract <T> T map(MaperEntity<T> maperEntity);

}
