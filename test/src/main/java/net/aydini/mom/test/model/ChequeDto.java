package net.aydini.mom.test.model;

import java.math.BigDecimal;

public class ChequeDto {
	
	private BigDecimal amount;
	
	private Long id;
	
	private AccountDto account;

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

	public AccountDto getAccount() {
		return account;
	}

	public void setAccount(AccountDto account) {
		this.account = account;
	}
	
	
	

}
