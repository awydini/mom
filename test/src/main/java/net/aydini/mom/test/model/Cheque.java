package net.aydini.mom.test.model;

import java.math.BigDecimal;

public class Cheque {
	
	private BigDecimal amount;
	
	private Long id;
	
	private Account account;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	

}
