package net.aydini.mom.util.mapper;

import java.math.BigDecimal;

import net.aydini.mom.common.service.maper.Maper;

public class BigdecimalToLongMapper implements Maper<BigDecimal, Long> {

	@Override
	public Long map(BigDecimal input) {
		if (input == null)
			return null;
		return input.longValue();
	}

}
