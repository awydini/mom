package net.aydini.mom.mapper;

import java.lang.reflect.Field;
import java.util.Set;

import net.aydini.mom.common.domain.Condition;
import net.aydini.mom.common.holder.ConditionalMaperEntity;
import net.aydini.mom.common.service.maper.ConditionalMaper;
import net.aydini.mom.filler.FillerFactory;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 29, 2021
 */
public abstract class MegaConditionalMaper implements ConditionalMaper
{
    @Override
    public final <T,C> T map(Object source, Class<T> targetClass,Condition<C> condition)
    {
        return map(new ConditionalMaperEntity<T,C>(source, targetClass,condition));
    }

    protected  <T,C> T map(final ConditionalMaperEntity<T,C> maperEntity)
    {
        getMapingFields(maperEntity.getTargetClass()).parallelStream()
        .forEach(item->FillerFactory.getFieldFiller(this).fill(maperEntity, item));
        return maperEntity.getTarget();
    }
    
    protected abstract <T> Set<Field> getMapingFields(Class<T> targetClass);
}
