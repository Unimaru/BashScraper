package pl.tb.extraction;

import java.util.List;

public interface Extractor {
    List<WebData> extractDataFrom(List<Page> pageList);
}
