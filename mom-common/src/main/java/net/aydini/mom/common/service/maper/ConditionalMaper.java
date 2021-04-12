package net.aydini.mom.common.service.maper;

import net.aydini.mom.common.domain.Condition;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 29, 2021
 */
public abstract class ConditionalMaper implements ObjectMaper 
{
    private final Condition condition;
    
    public ConditionalMaper(Condition condition)
    {
        this.condition = condition;
    }

    public Condition getCondition()
    {
        return condition;
    }
    
    
}
