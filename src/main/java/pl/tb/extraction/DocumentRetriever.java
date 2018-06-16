package pl.tb.extraction;

import org.jsoup.nodes.Document;

public interface DocumentRetriever {

    DocumentData retrieveDocumentDataFrom(String URL);
}
