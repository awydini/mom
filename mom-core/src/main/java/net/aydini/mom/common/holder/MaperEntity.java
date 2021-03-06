package net.aydini.mom.common.holder;

import net.aydini.mom.common.exception.MomBaseException;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 29, 2021
 */
public class MaperEntity<T>
{

    private final Object source;
    private final Class<T> targetClass;
    private T target;

    public MaperEntity(Object source, Class<T> targetClass)
    {
        this.source = source;
        this.targetClass = targetClass;
        instantiateTarget();
    }

    protected void instantiateTarget()
    {
        try
        {
            assert targetClass != null : "target class is null";
            target = targetClass.getConstructor().newInstance(new Object[] {});
        }
        catch (Exception e)
        {
            throw new MomBaseException(e.getMessage(), e);
        }
    }

    public Object getSource()
    {
        return source;
    }

    public Class<?> getTargetClass()
    {
        return targetClass;
    }

    public T getTarget()
    {
        return target;
    }

}
