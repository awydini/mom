package net.aydini.mom.mapper;

import java.lang.reflect.Field;

import net.aydini.mom.common.service.filler.FieldFiller;
import net.aydini.mom.filler.FillerFactory;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Apr 10, 2021
 */
public class MegaObjectMaper extends AbstractObjectMaper
{

	@Override
	protected FieldFiller getFieldFiller(Field field) {
		return new FillerFactory().getFieldFiller(field, this);
	}

}
