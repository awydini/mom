package net.aydini.mom.util.reflection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class ReflectionUtilsTests {

	public static class CollectionTypeArgument implements ArgumentsProvider {

		@Override
		public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {

			return Stream.of(Arguments.of(Collection.class), Arguments.of(List.class), Arguments.of(Set.class),
					Arguments.of(ArrayList.class));
		}

	}

	@ParameterizedTest
	@ArgumentsSource(value = CollectionTypeArgument.class)
	public void shouldThrowNationalCodValidationExcrptionForInvalid(Class<?> clazz) {
		System.out.println("checking if " + clazz.getSimpleName() + " is Collection with argument ");
		assertTrue(ReflectionUtil.isCollection(clazz));
	}

	@Test
	public void isCollectionSouldReturnFalse() {
		assertFalse(ReflectionUtil.isCollection(String.class));
		assertFalse(ReflectionUtil.isCollection(Integer.class));
		assertFalse(ReflectionUtil.isCollection(BigDecimal.class));
		assertFalse(ReflectionUtil.isCollection(File.class));
	}
}
