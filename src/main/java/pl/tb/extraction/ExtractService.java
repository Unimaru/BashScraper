package pl.tb.extraction;

import pl.tb.statistics.StatisticsService;

import java.util.List;

public class ExtractService {

    public List<WebData> extractData(Long pageLimit, StatisticsService statisticsService) {
        List<Page> pages = new WebPageLoader().loadPagesLimitedTo(pageLimit, new WebReceiver("http://bash.org.pl/latest/"));
        return new WebExtractor(statisticsService).extractDataFrom(pages);
    }
}
