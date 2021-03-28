package net.aydini.mom.util.reflection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import net.aydini.mom.util.TestCase;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 28, 2021
 */
public class RWMethodNameTests
{

    public static class TestClass
    {
        private boolean boolField;
        private String stringField;
        private Boolean boxedBoolField;
        private Long longField;

        public boolean isBoolField()
        {
            return boolField;
        }

        public void setBoolField(boolean boolField)
        {
            this.boolField = boolField;
        }

        public String getStringField()
        {
            return stringField;
        }

        public void setStringField(String stringField)
        {
            this.stringField = stringField;
        }

        public Boolean getBoxedBoolField()
        {
            return boxedBoolField;
        }

        public void setBoxedBoolField(Boolean boxedBoolField)
        {
            this.boxedBoolField = boxedBoolField;
        }
    }

    public static class ReadMethodArgument implements ArgumentsProvider
    {
        private List<TestCase> testCases = new ArrayList<>();

        private void init()
        {
            testCases.add(new TestCase("boolField", "isBoolField"));
            testCases.add(new TestCase("stringField", "getStringField"));
            testCases.add(new TestCase("boxedBoolField", "getBoxedBoolField"));
        }

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception
        {
            init();
            return testCases.stream().map(item -> Arguments.of(item));
        }

    }

    public static class WriteMethodArgument implements ArgumentsProvider
    {
        private List<TestCase> testCases = new ArrayList<>();

        private void init()
        {
            testCases.add(new TestCase("boolField", "setBoolField"));
            testCases.add(new TestCase("stringField", "setStringField"));
            testCases.add(new TestCase("boxedBoolField", "setBoxedBoolField"));
        }

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception
        {
            init();
            return testCases.stream().map(item -> Arguments.of(item));
        }

    }

    @ParameterizedTest
    @ArgumentsSource(value = ReadMethodArgument.class)
    public void createReaderMethodName_test(TestCase test) throws Throwable
    {
        String readermethodName = RWMethodName.createReaderMethodName(TestClass.class.getDeclaredField((String) test.getWhen()));
        assertEquals(test.getThen(), readermethodName);

    }

    @ParameterizedTest
    @ArgumentsSource(value = WriteMethodArgument.class)
    public void createWriterMethodName_test(TestCase test) throws Throwable
    {
        String writerMethodName = RWMethodName.createWriterMethodName(TestClass.class.getDeclaredField((String) test.getWhen()));
        assertEquals(test.getThen(), writerMethodName);

    }

}
