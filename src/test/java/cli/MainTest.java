package cli;

import data.Result;
import main.CsvParser;
import main.DataProcessor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainTest {
    private ByteArrayOutputStream outContent;
    private ByteArrayOutputStream errContent;
    private CsvParser csvParser;
    private DataProcessor processor;
    private Main main;

    private Result testResult = new Result
            .Builder()
            .setBreedCAgentsNumber(1)
            .setBreedNCAgentsNumber(2)
            .setLostBreedCNumber(3)
            .setGainedBreedCNumber(4)
            .setRegainedBreedCNumber(5)
            .build();

    @Before
    public void setUpStreamsAndInitialiseVariables() {
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        csvParser = mock(CsvParser.class);
        processor = mock(DataProcessor.class);
        main = new Main(csvParser, processor);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void run_ShouldPrintToStderr_WhenArgumentsInWrongFormat() {
        main.run(new String[]{"abc"});
        assertEquals("Wrong number of arguments" + "\n" +
                "Usage: agents --process <input_file_path> <brand_factor>\n", errContent.toString
                ());
    }

    @Test
    public void run_ShouldPrintToStdout() {
        when(csvParser.readCsv(anyString())).thenReturn(Collections.emptyList());
        when(processor.process(anyList(), anyDouble())).thenReturn(testResult);
        main.run(new String[]{"--process", "abc", "1"});
        assertEquals("Result{breedCAgentsNumber=1, breedNCAgentsNumber=2, " +
                        "lostBreedCNumber=3, gainedBreedCNumber=4, regainedBreedCNumber=5}\n",
                outContent.toString());
    }
}
