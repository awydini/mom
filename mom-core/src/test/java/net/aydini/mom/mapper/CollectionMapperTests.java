package net.aydini.mom.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.aydini.mom.model.Person;
import net.aydini.mom.model.User;
import net.aydini.mom.model.UserDto;

public class CollectionMapperTests {

	private User user;
	private CollectionMapper collectionMapper = new CollectionMapper( new SimpleObjectMaper());
	
	private List<UserDto> userDtoList;
	List<User> list;
	
	
	@BeforeEach
	public void init()
	{
		user = new User("aydin", "123", LocalDate.now());
        Person person = new Person();
        person.setAge(18);
        person.setName("joe");
        user.setPerson(person);
        list = Arrays.asList(user);
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void mapCollectionTest() throws Exception
	{
		userDtoList = (List<UserDto>) collectionMapper.map(list.stream().map(item->(Object)item).collect(Collectors.toList()), CollectionMapperTests.class.getDeclaredField("userDtoList"));
		 assertNotNull(userDtoList);
		 assertEquals(list.size(), userDtoList.size());
		 assertEquals(list.get(0).getPerson(), userDtoList.get(0).getPerson());
		 assertEquals(list.get(0).getPassword(), userDtoList.get(0).getPassword());
		 
		 
	}
	
	
}
