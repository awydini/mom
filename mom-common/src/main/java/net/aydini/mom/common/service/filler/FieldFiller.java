package net.aydini.mom.common.service.filler;

import java.lang.reflect.Field;

import net.aydini.mom.common.holder.MaperEntity;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 31, 2021
 */
public interface FieldFiller
{

    public <T> void fill(MaperEntity<T> maperEntity , Field field);
}
