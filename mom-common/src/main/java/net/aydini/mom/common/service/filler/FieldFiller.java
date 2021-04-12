package net.aydini.mom.common.service.filler;

import java.lang.reflect.Field;

import net.aydini.mom.common.holder.ConditionalMaperEntity;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 31, 2021
 */
public interface FieldFiller
{

    public <T,C> void fill(ConditionalMaperEntity<T,C> maperEntity , Field field);
}
