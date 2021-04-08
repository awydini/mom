package net.aydini.mom.mapper;

import net.aydini.mom.common.domain.Condition;
import net.aydini.mom.common.holder.ConditionalMaperEntity;
import net.aydini.mom.common.holder.MaperEntity;
import net.aydini.mom.common.service.maper.ConditionalMaper;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 29, 2021
 */
public abstract class AbstractConditionalMaper implements ConditionalMaper
{
    public final <T,C> T map(Object source, Class<T> targetClass,Condition<C> condition)
    {
        return map(new ConditionalMaperEntity<T,C>(source, targetClass,condition));
    }
    
    protected abstract <T> T map(MaperEntity<T> maperEntity);
}
