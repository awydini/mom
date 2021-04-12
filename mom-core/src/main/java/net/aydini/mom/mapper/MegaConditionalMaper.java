package net.aydini.mom.mapper;

import java.lang.reflect.Field;
import java.util.Set;

import net.aydini.mom.common.domain.Condition;
import net.aydini.mom.common.holder.MaperEntity;
import net.aydini.mom.filler.FillerFactory;
import net.aydini.mom.util.reflection.FieldWarehouse;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 29, 2021
 */
public class MegaConditionalMaper extends AbstractObjectMaper
{
    private final Condition condition;
    
    public MegaConditionalMaper(Condition condition)
    {
        this.condition = condition;
    }

    public Condition getCondition()
    {
        return condition;
    }


    protected  <T> T map(final MaperEntity<T> maperEntity)
    {
        getMapingFields(maperEntity.getTargetClass()).parallelStream()
        .forEach(item->FillerFactory.getConditionalFieldFiller(this).fill(maperEntity, item));
        return maperEntity.getTarget();
    }
    
    protected  <T> Set<Field> getMapingFields(Class<T> targetClass)
    {
        return FieldWarehouse.getClassFields(targetClass);
    }
}
