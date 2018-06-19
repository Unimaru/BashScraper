package pl.tb.extraction;

import pl.tb.statistics.StatisticsService;

import java.util.List;

public class ExtractService {

    public List<WebData> extractData(Long pageLimit, StatisticsService statisticsService) {
        List<Page> pages = new WebPageLoader(new WebReceiver("http://bash.org.pl/latest/")).loadPagesLimitedTo(pageLimit);
        return new WebExtractor(statisticsService).extractDataFrom(pages);
    }
}
