package pl.tb.extraction;

import org.jsoup.nodes.Document;

public interface Extractor<T> {
    T extractDataFrom(DocumentRetriever documentRetriever, String request);
}
