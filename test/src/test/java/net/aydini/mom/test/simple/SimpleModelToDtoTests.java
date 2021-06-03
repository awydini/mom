package net.aydini.mom.test.simple;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import net.aydini.mom.mapper.SimpleObjectMaper;
import net.aydini.mom.test.model.Account;
import net.aydini.mom.test.model.Cheque;
import net.aydini.mom.test.model.ChequeDto;
import net.aydini.mom.test.model.Person;
import net.aydini.mom.test.model.PersonDto;
import net.aydini.mom.test.model.Phone;

public class SimpleModelToDtoTests {

	
	private static Person person;
	
	
	private static Cheque cheque;
	
	
	private SimpleObjectMaper mapper = new SimpleObjectMaper();
	
	@BeforeAll
	public static void init()
	{
		person = new Person();
		person.setName("Adyin");
		person.setFamily("Nasrollahpour");
		List<Phone> phones = new ArrayList<>();
		person.setPhones(phones);
		Phone phone1 = new Phone();
		phone1.setBrand("iphone");
		phone1.setModel("11");
		
		Phone phone2 = new Phone();
		phone2.setBrand("sumsung");
		phone2.setModel("note10");
		
		
		phones.add(phone1);
		phones.add(phone2);
		
		
		/**
		 * -------------------------------------
		 */
		
		Account account = new Account();
		account.setAccountNo("123456798");
		account.setBalance(new BigDecimal(1000L));
		account.setId(1L);
		
		cheque = new Cheque();
		cheque.setAmount(BigDecimal.ONE);
		cheque.setId(1L);
		cheque.setAccount(account);
		
		
		
	}

	@Test
	public void accountToAccountDtoTest()
	{
		ChequeDto chequeDto = mapper.map(cheque, ChequeDto.class);
		
		assertNotNull(chequeDto);
		assertNotNull(chequeDto.getAccount());
		assertEquals(cheque.getAmount(), chequeDto.getAmount());
		assertEquals(cheque.getId(), chequeDto.getId());
		
		assertEquals(cheque.getAccount().getId(), chequeDto.getAccount().getId());
		assertEquals(cheque.getAccount().getBalance(), chequeDto.getAccount().getBalance());
		assertEquals(cheque.getAccount().getAccountNo(), chequeDto.getAccount().getAccountNo());
		
	}
	
	
	
	@Test
	public void personToPersonDtoTest()
	{
		PersonDto personDto = mapper.map(person, PersonDto.class);
		
		assertNotNull(personDto);
		assertEquals(person.getAge(),personDto.getAge());
		assertEquals(person.getName(),personDto.getName());
		assertEquals(person.getFamily(),personDto.getFamily());
		
		
	}

}
