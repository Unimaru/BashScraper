package pl.tb.extraction;

import org.jsoup.nodes.Document;

import java.util.List;

public interface Extractor<T> {
    T extractDataFrom(List<Page> pageList);
}
