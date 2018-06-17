package pl.tb.extraction;

import java.util.List;

public class ExtractService {

    public List<WebData> extractData(Long pageLimit) {
        List<Page> pages = new WebPageLoader().loadPagesLimitedTo(pageLimit, new WebReceiver("http://bash.org.pl/latest/"));
        return new WebExtractor().extractDataFrom(pages);
    }
}
