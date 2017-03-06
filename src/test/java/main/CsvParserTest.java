package main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CsvParserTest {
    @Test
    public void parseCsv_ShouldThrow_WhenFileCannotBeParsed() {
        try {
            CsvParser parser = new CsvParser(new StringToAgentConverter());
            parser.readCsv("abc");
            fail("RuntimeException expected");
        } catch (RuntimeException e) {
            assertEquals("Error occurred while reading input file: abc", e.getMessage());
        }
    }
}
