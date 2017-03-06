package cli;

import org.junit.Test;

import static cli.ArgumentsValidator.validateArguments;
import static com.sun.tools.internal.ws.wsdl.parser.Util.fail;
import static org.junit.Assert.assertEquals;

public class ArgumentsValidatorTest {

    @Test
    public void readArguments_shouldThrow_whenWrongArgumentsNumber() {
        try {
            validateArguments(new String[]{"a", "b"});
            fail("RuntimeException expected");
        } catch (RuntimeException e) {
            assertEquals("Wrong number of arguments", e.getMessage());
        }
    }

    @Test
    public void readArguments_shouldThrow_whenWrongFirstArgument() {
        try {
            validateArguments(new String[]{"abc", "abc", "1"});
            fail("RuntimeException expected");
        } catch (RuntimeException e) {
            assertEquals("Wrong first argument", e.getMessage());
        }
    }

    @Test
    public void readArguments_shouldThrow_whenThirdArgumentIsNotNumber() {
        try {
            validateArguments(new String[]{"--process", "abc", "abc"});
            fail("RuntimeException expected");
        } catch (RuntimeException e) {
            assertEquals("Third argument is not a number", e.getMessage());
        }
    }

    @Test
    public void readArguments_shouldThrow_whenThirdArgumentIsLessThanMinBrandFactorNumber() {
        try {
            validateArguments(new String[]{"--process", "abc", "-3"});
            fail("RuntimeException expected");
        } catch (RuntimeException e) {
            assertEquals("Third argument is less than 0.1", e.getMessage());
        }
    }

    @Test
    public void readArguments_shouldThrow_whenThirdArgumentIsGreaterThanMaxBrandFactorNumber() {
        try {
            validateArguments(new String[]{"--process", "abc", "5"});
            fail("RuntimeException expected");
        } catch (RuntimeException e) {
            assertEquals("Third argument is greater than 2.9", e.getMessage());
        }
    }
}
