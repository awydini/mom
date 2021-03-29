package net.aydini.mom.mapper;

import net.aydini.mom.common.holder.ConditionalMaperEntity;
import net.aydini.mom.common.holder.MaperEntity;
import net.aydini.mom.common.service.Condition;
import net.aydini.mom.common.service.ObjectMaper;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 29, 2021
 */
public abstract class AbstractConditionalMaper implements ObjectMaper
{
    public final <T,C> T map(Object source, Class<T> targetClass,Condition<C> condition)
    {
        return map(new ConditionalMaperEntity<T,C>(source, targetClass,condition));
    }
    
    protected abstract <T> T doMap(MaperEntity<T> maperEntity);
}
