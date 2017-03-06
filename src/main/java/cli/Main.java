package cli;

import data.Agent;
import main.CsvParser;
import main.DataProcessor;
import main.StringToAgentConverter;

import java.util.List;

public class Main {
    private CsvParser csvParser;
    private DataProcessor dataProcessor;

    public Main(CsvParser csvParser, DataProcessor dataProcessor) {
        this.csvParser = csvParser;
        this.dataProcessor = dataProcessor;
    }

    //TODO: add argument validation
    public static void main(String[] args) {
        StringToAgentConverter converter = new StringToAgentConverter();
        CsvParser csvParser = new CsvParser(converter);
        DataProcessor processor = new DataProcessor();
        Main main = new Main(csvParser, processor);
        main.run(args);
    }

    public void run(String[] args) {
        List<Agent> agents = csvParser.readCsv(args[0]);
        System.out.println(dataProcessor.process(agents, Double.parseDouble(args[1])));
    }
}
