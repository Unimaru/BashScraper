package pl.tb;

import org.apache.commons.cli.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pl.tb.configuration.ConfigProvider;
import pl.tb.extraction.ExtractService;
import pl.tb.extraction.WebData;
import pl.tb.filehandling.SaveService;
import pl.tb.statistics.StatisticsService;

import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final ConfigProvider configProvider = new ConfigProvider();
    private static final StatisticsService statisticsService = new StatisticsService();
    private static final ExtractService extractService = new ExtractService();
    private static final SaveService saveService = new SaveService(configProvider);

    public static void main(String[] args) throws ParseException {

        Long limit = createLimitFromCLI(args);

        logger.info("Starting parse bash.org.pl data limited to: " + limit + " pages.");
        List<WebData> webData = extractService.extractData(limit, statisticsService);
        saveService.saveToFile(webData);
        logger.info("There was: " + webData.size() + " elements to processed");
        logger.info(statisticsService.getStatistics());
        logger.info("End parsing bash.org.pl.");
    }

    private static Long createLimitFromCLI(String[] args) throws ParseException {
        HelpFormatter formatter = new HelpFormatter();
        Options options = new Options();
        options.addOption(new Option("p", true, "Number of pages"));
        Long value = null;

        formatter.printHelp("BashScraper", options);

        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine commandLine = commandLineParser.parse(options, args);

        if (commandLine.hasOption("p")) {
            value = Long.valueOf(commandLine.getOptionValue("p"));
        }else{
            throw new RuntimeException("No limit parameter");
        }
        return value;
    }
}
