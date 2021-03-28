package net.aydini.mom.util.reflection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import net.aydini.mom.util.TestCase;
import net.aydini.mom.util.reflection.RWMethodNameTests.ReadMethodArgument;
import net.aydini.mom.util.reflection.RWMethodNameTests.TestClass;
import net.aydini.mom.util.reflection.RWMethodNameTests.WriteMethodArgument;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 28, 2021
 */
public class RWPropertyTests
{

    @ParameterizedTest
    @ArgumentsSource(value = ReadMethodArgument.class)
    public void getReaderMethod_test(TestCase test) throws Throwable
    {
        Optional<Method> readerMethod = RWProperty.getReaderMethod(TestClass.class,
                TestClass.class.getDeclaredField((String) test.getWhen()));
        assertTrue(readerMethod.isPresent());
        assertEquals(test.getThen(), readerMethod.get().getName());

    }

    @Test
    public void getReaderMethod_should_return_empty_optional_test() throws Throwable
    {
        Optional<Method> readerMethod = RWProperty.getReaderMethod(TestClass.class, TestClass.class.getDeclaredField("longField"));
        assertFalse(readerMethod.isPresent());
    }

    @ParameterizedTest
    @ArgumentsSource(value = WriteMethodArgument.class)
    public void getWriterMethod_test(TestCase test) throws Throwable
    {
        Optional<Method> writerMethod = RWProperty.getWriterMethod(TestClass.class,
                TestClass.class.getDeclaredField((String) test.getWhen()));
        assertTrue(writerMethod.isPresent());
        assertEquals(test.getThen(), writerMethod.get().getName());

    }
}
