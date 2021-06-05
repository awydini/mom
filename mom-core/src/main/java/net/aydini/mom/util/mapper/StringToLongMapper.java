package net.aydini.mom.util.mapper;

import net.aydini.mom.common.exception.MomBaseException;
import net.aydini.mom.common.service.maper.Maper;

public class StringToLongMapper implements Maper<String, Integer> {

	@Override
	public Integer map(String input) {

		if (input == null || input.isEmpty())
			return null;

		try {

			return Integer.parseInt(input);
		} catch (NumberFormatException e) {

			throw new MomBaseException(e.getMessage(), e);
		}

	}

}
