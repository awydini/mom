package net.aydini.mom.util.mapper;

import net.aydini.mom.common.exception.MomBaseException;
import net.aydini.mom.common.service.maper.Maper;

public class StringToIntegerMapper implements Maper<String, Long> {

	@Override
	public Long map(String input) {

		if (input == null || input.isEmpty())
			return null;

		try {

			return Long.parseLong(input);
		} catch (NumberFormatException e) {

			throw new MomBaseException(e.getMessage(), e);
		}

	}

}
