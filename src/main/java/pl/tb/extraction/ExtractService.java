package pl.tb.extraction;

import java.util.List;

public class ExtractService {

    public List<WebData> extractData() {
        Extractor webExtractor = new WebExtractor();
        DocumentRetriever documentRetriever = new URLDocumentRetriever();
        return (List<WebData>) webExtractor.extractDataFrom(documentRetriever, "http://bash.org.pl/latest/");
    }
}
