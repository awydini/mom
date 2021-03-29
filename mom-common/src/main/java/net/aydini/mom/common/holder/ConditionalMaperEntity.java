package net.aydini.mom.common.holder;

import net.aydini.mom.common.service.Condition;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 29, 2021
 */
public class ConditionalMaperEntity<T, C> extends MaperEntity<T>
{

    private final Condition<C> condition;

    public ConditionalMaperEntity(Object source, Class<T> targetClass, Condition<C> condition)
    {
        super(source, targetClass);
        this.condition = condition;
    }

    public Condition<C> getCondition()
    {
        return condition;
    }

}
