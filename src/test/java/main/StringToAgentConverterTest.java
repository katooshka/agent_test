package main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StringToAgentConverterTest {

    @Test
    public void convertStringToAgent_ShouldThrow_WhenWrongFieldsNumber() {
        try {
            StringToAgentConverter converter = new StringToAgentConverter();
            converter.convertStringToAgent("a,b");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Fields number not as expected", e.getMessage());
        }
    }

    @Test
    public void convertStringToAgent_ShouldThrow_WhenWrongFirstArgument() {
        try {
            StringToAgentConverter converter = new StringToAgentConverter();
            converter.convertStringToAgent(",b,c,c,c,c,c,c,c,c");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Breed field of the input file is empty", e.getMessage());
        }
    }

    @Test
    public void convertStringToAgent_ShouldThrow_WhenFieldNotANumber() {
        try {
            StringToAgentConverter converter = new StringToAgentConverter();
            converter.convertStringToAgent("a,b,1,1,1,1,1,1,1,1");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            assertEquals(
                    "Some numeric fields of the input file are not numbers: For input string: \"b\"",
                    e.getMessage());
        }
    }
}
