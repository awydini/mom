package net.aydini.mom.util.mapper;

import java.math.BigDecimal;

import net.aydini.mom.common.service.maper.Maper;

public class LongToBigdecimalMapper implements Maper<Long, BigDecimal> {

	@Override
	public BigDecimal map(Long input) {

		if (input == null)
			return null;
		return new BigDecimal(input);
	}

}
