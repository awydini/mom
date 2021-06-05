package net.aydini.mom.util.mapper;

import net.aydini.mom.common.service.maper.Maper;

public class ToStringMapper implements Maper<Object, String> {

	@Override
	public String map(Object input) {

		if (input == null)
			return null;
		return input.toString();
	}

}
