package net.aydini.mom.common.holder;

import net.aydini.mom.common.domain.Condition;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 29, 2021
 */
public class ConditionalMaperEntity<T> extends MaperEntity<T>
{

    private final Condition condition;

    public ConditionalMaperEntity(Object source, Class<T> targetClass, Condition condition)
    {
        super(source, targetClass);
        this.condition = condition;
    }

    public Condition getCondition()
    {
        return condition;
    }

}
