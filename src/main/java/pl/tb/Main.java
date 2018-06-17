package pl.tb;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.commons.cli.*;
import pl.tb.extraction.ExtractService;
import pl.tb.extraction.WebData;
import pl.tb.filehandling.SaveToFile;

import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {

        Options options = new Options();
        options.addOption(new Option("p", true, "Number of pages"));
        Long value = null;

        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine commandLine = commandLineParser.parse(options, args);

        if (commandLine.hasOption("p")) {
            value = Long.valueOf(commandLine.getOptionValue("p"));
        } else {
            System.out.println("NO pages");
        }

        ExtractService extractService = new ExtractService();
        List<WebData> webData = extractService.extractData(value);
        new SaveToFile().save(webData);
    }
}
