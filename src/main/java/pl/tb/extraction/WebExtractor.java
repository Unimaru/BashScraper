package pl.tb.extraction;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import pl.tb.statistics.StatisticsData;
import pl.tb.statistics.StatisticsService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WebExtractor implements Extractor<List<WebData>> {

    StatisticsService statisticsService;

    public WebExtractor(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Override
    public List<WebData> extractDataFrom(List<Page> pageList) {
        List<WebData> result = new ArrayList<>();
        List<StatisticsData> statisticsData = new LinkedList<>();
        pageList.stream().forEach(page -> {
            Long start = System.nanoTime();
            result.addAll(extract(page.getContent()));
            Long end = System.nanoTime();
            statisticsData.add(new StatisticsData(new Long(start), new Long(end)));
        });
        statisticsService.addToNamedStatistics("Page", statisticsData);
        return result;
    }

    private List<WebData> extract(Document document) {
        List<WebData> result = new LinkedList<>();
        List<StatisticsData> statisticsData = new LinkedList<>();
        Elements elementsByAttribute = document.body().getElementsByClass("q post");
        elementsByAttribute.stream().forEach(element -> {
            Long start = System.nanoTime();
            Long id = Long.valueOf(element.id().replaceAll("[^0-9.]", ""));
            Long points = Long.valueOf(element.getElementsByClass("points").text());
            String content = element.getElementsByClass("quote post-content post-body").text();
            result.add(new WebData(id, points, content));
            Long end = System.nanoTime();
            statisticsData.add(new StatisticsData(new Long(start), new Long(end)));
        });
        statisticsService.addToNamedStatistics("Element", statisticsData);
        return result;
    }

}
