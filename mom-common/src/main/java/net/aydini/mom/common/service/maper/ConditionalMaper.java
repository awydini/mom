package net.aydini.mom.common.service.maper;

import net.aydini.mom.common.domain.Condition;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 29, 2021
 */
public interface ConditionalMaper 
{
    public <T, C> T map(Object source, Class<T> targetClass, Condition<C> condition);
}
