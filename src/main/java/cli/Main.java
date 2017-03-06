package cli;

import data.Agent;
import main.CsvParser;
import main.DataProcessor;
import main.StringToAgentConverter;

import java.util.List;
import java.util.Locale;

import static cli.ArgumentsValidator.*;

public class Main {
    private CsvParser csvParser;
    private DataProcessor dataProcessor;

    public Main(CsvParser csvParser, DataProcessor dataProcessor) {
        this.csvParser = csvParser;
        this.dataProcessor = dataProcessor;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        StringToAgentConverter converter = new StringToAgentConverter();
        CsvParser csvParser = new CsvParser(converter);
        DataProcessor processor = new DataProcessor();
        Main main = new Main(csvParser, processor);
        main.run(args);
    }

    public void run(String[] args) {
        try {
            validateArguments(args);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            showUsage();
            return;
        }
        try {
            List<Agent> agents = csvParser.readCsv(args[0]);
            System.out.println(dataProcessor.process(agents, Double.parseDouble(args[1])));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void showUsage() {
        System.err.println("Usage: agents --process <input_file_path> <brand_factor>");
    }
}
