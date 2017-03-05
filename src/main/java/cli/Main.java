package cli;

import main.CsvProcessor;
import main.StringToAgentConverter;

public class Main {
    private CsvProcessor csvProcessor;

    public Main(CsvProcessor csvProcessor) {
        this.csvProcessor = csvProcessor;
    }

    //TODO: add argument validation
    public static void main(String[] args) {
        StringToAgentConverter converter = new StringToAgentConverter();
        CsvProcessor csvProcessor = new CsvProcessor(converter);
        Main main = new Main(csvProcessor);
        main.run(args);
    }

    public void run(String[] args) {
        System.out.println(csvProcessor.readCsv(args[0]));
    }
}
