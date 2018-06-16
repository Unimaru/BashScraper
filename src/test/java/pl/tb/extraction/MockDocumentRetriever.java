package pl.tb.extraction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MockDocumentRetriever implements DocumentRetriever {

    @Override
    public DocumentData retrieveDocumentDataFrom(String request) {
        Document parse = Jsoup.parse(MockPageChooser.choosePage(request));
        return new DocumentData(parse, hasNextPage(parse), nextPageName(request, parse));
    }

    private String nextPageName(String request, Document document) {
        return request.concat(document.body().getElementsByClass("next").attr("href"));
    }

    public boolean hasNextPage(Document document) {
        return !document.body().getElementsByClass("next").attr("href").equals("");
    }

}
