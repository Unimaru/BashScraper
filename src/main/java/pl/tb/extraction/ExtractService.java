package pl.tb.extraction;

import java.io.IOException;

public class ExtractService {

    public void extractData() throws IOException {
        Extractor webExtractor = new WebExtractor();
        webExtractor.extractDataFrom();
    }
}
