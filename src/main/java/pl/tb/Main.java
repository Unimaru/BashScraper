package pl.tb;

import org.apache.commons.cli.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pl.tb.extraction.ExtractService;
import pl.tb.extraction.WebData;
import pl.tb.filehandling.SaveToFile;
import pl.tb.statistics.StatisticsService;

import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    private static StatisticsService statisticsService = new StatisticsService();

    public static void main(String[] args) throws ParseException {

        Long limit = createLimitFromCLI(args);

        ExtractService extractService = new ExtractService();
        logger.info("Starting parse bash.org.pl data limited to: " + limit + " pages.");
        List<WebData> webData = extractService.extractData(limit, statisticsService);
        new SaveToFile().save(webData);
        logger.info("There was: " + webData.size() + " elements to processed");
        logger.info(statisticsService.getStatistics());
        logger.info("End parsing bash.org.pl.");
    }

    private static Long createLimitFromCLI(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption(new Option("p", true, "Number of pages"));
        Long value = null;

        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine commandLine = commandLineParser.parse(options, args);

        if (commandLine.hasOption("p")) {
            value = Long.valueOf(commandLine.getOptionValue("p"));
        }
        return value;
    }
}
