package net.aydini.mom.common.service;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 29, 2021
 */
public interface ConditionalMaper
{
    public <C> Object map(Object input, Condition<C> condition);
}
