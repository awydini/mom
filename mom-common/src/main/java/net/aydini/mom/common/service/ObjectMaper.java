package net.aydini.mom.common.service;

import net.aydini.mom.common.holder.MaperEntity;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 29, 2021
 */
public interface ObjectMaper
{
    public <T> T map(MaperEntity<T> maperEntity);
    
}
