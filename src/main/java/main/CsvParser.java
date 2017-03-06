package main;

import data.Agent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    private StringToAgentConverter converter;

    public CsvParser(StringToAgentConverter converter) {
        this.converter = converter;
    }

    public List<Agent> readCsv(String filename) {
        List<Agent> agents = new ArrayList<>();
        try {
            try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
                br.readLine();
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    agents.add(converter.convertStringToAgent(line));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while reading while reading input file");
        }
        return agents;
    }
}
