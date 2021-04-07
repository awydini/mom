package net.aydini.mom.common.holder;

import java.lang.reflect.Field;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 31, 2021
 */
public class FillerEntity<T>
{

    private final MaperEntity<T> maperEntity;
    private final Field field;
    private Object fieldValue;
    
    public FillerEntity(MaperEntity<T> maperEntity, Field field)
    {
        super();
        this.maperEntity = maperEntity;
        this.field = field;
    }

    public Object getFieldValue()
    {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue)
    {
        this.fieldValue = fieldValue;
    }

    public MaperEntity<T> getMaperEntity()
    {
        return maperEntity;
    }

    public Field getField()
    {
        return field;
    }
    
    
    
    
    
}
