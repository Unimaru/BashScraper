package pl.tb;

import pl.tb.extraction.ExtractService;
import pl.tb.extraction.WebData;
import pl.tb.filehandling.SaveToFile;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        ExtractService extractService = new ExtractService();
        List<WebData> webData = extractService.extractData();
        new SaveToFile().save(webData);
    }
}
