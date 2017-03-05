package cli;

import main.CvsProcessor;
import main.StringToAgentConverter;

public class Main {
    private CvsProcessor cvsProcessor;

    public Main(CvsProcessor cvsProcessor) {
        this.cvsProcessor = cvsProcessor;
    }

    //TODO: add argument validation
    public static void main(String[] args) {
        StringToAgentConverter converter = new StringToAgentConverter();
        CvsProcessor cvsProcessor = new CvsProcessor(converter);
        Main main = new Main(cvsProcessor);
        main.run(args);
    }

    public void run(String[] args) {
        System.out.println(cvsProcessor.readCvs(args[0]));
    }
}
