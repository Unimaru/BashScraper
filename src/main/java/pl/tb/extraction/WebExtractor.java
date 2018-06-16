package pl.tb.extraction;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WebExtractor implements Extractor<List<WebData>> {

    @Override
    public List<WebData> extractDataFrom(DocumentRetriever documentRetriever, String request) {
        List<WebData> result = new ArrayList<>();
        DocumentData document = documentRetriever.retrieveDocumentDataFrom(request);
        do {
            result.addAll(extract(document.getDocument()));
            document = documentRetriever.retrieveDocumentDataFrom(document.getNextPageRequest());
        } while (document.getHasNextPage());
        result.addAll(extract(document.getDocument()));
        return result;
    }

    private List<WebData> extract(Document document) {
        List<WebData> result = new LinkedList<>();
        Elements elementsByAttribute = document.body().getElementsByClass("q post");
        elementsByAttribute.stream().forEach(element -> {
            Long id = Long.valueOf(element.id().replaceAll("[^0-9.]", ""));
            Long points = Long.valueOf(element.getElementsByClass("points").text());
            String content = element.getElementsByClass("quote post-content post-body").text();
            result.add(new WebData(id, points, content));
        });
        return result;
    }

}
