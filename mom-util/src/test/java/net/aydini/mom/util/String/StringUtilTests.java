package net.aydini.mom.util.String;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import net.aydini.mom.util.TestCase;
import net.aydini.mom.util.string.StringUtil;

public class StringUtilTests
{

    public static class FirstLetterUpperCaseArgument implements ArgumentsProvider
    {

        private List<TestCase> testCases = new ArrayList<>();

        private void init()
        {
            testCases.add(new TestCase("Aydin", "Aydin"));
            testCases.add(new TestCase("aydin", "Aydin"));
            testCases.add(new TestCase("1din", "1din"));
            testCases.add(new TestCase("123", "123"));
            testCases.add(new TestCase("*&^%", "*&^%"));
            testCases.add(new TestCase("a", "A"));
            testCases.add(new TestCase("", ""));
        }

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception
        {
            init();
            return testCases.stream().map(item -> Arguments.of(item));
        }

    }
    

    public static class FirstLetterLowerCaseArgument implements ArgumentsProvider
    {

        private List<TestCase> testCases = new ArrayList<>();

        private void init()
        {
            testCases.add(new TestCase("Aydin", "aydin"));
            testCases.add(new TestCase("aydin", "aydin"));
            testCases.add(new TestCase("1din", "1din"));
            testCases.add(new TestCase("123", "123"));
            testCases.add(new TestCase("*&^%", "*&^%"));
            testCases.add(new TestCase("A", "a"));
            testCases.add(new TestCase("", ""));
        }

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception
        {
            init();
            return testCases.stream().map(item -> Arguments.of(item));
        }

    }

    @ParameterizedTest
    @ArgumentsSource(value = FirstLetterLowerCaseArgument.class)
    public void toLowerFirstLetter_test(TestCase testCase)
    {
        String lowerFirstLetter = StringUtil.toLowerFirstLetter((String) testCase.getWhen());
        assertEquals(testCase.getThen(), lowerFirstLetter);
    }

    @ParameterizedTest
    @ArgumentsSource(value = FirstLetterUpperCaseArgument.class)
    public void toUpperFirstLetter_test(TestCase testCase)
    {
        String upperFirstLetter = StringUtil.toUpperFirstLetter((String) testCase.getWhen());
        assertEquals(testCase.getThen(), upperFirstLetter);
    }

    @Test
    public void toUpperFirstLetter_should_throw_NPE_on_null_input()
    {
        assertThrows(NullPointerException.class, ()->StringUtil.toUpperFirstLetter(null));
    }
}
