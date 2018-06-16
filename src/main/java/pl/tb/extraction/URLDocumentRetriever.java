package pl.tb.extraction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class URLDocumentRetriever implements DocumentRetriever {

    @Override
    public DocumentData retrieveDocumentDataFrom(String request) {
        Document parse = null;
        try {
            parse = Jsoup.parse(new URL(request),5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DocumentData(parse, hasNextPage(parse), nextPageName(request, parse));
    }

    private String nextPageName(String request, Document document) {
        return request.replaceAll("(\\?.*)","").concat(document.body().getElementsByClass("next").attr("href"));
    }

    public boolean hasNextPage(Document document) {
        return !document.body().getElementsByClass("next").attr("href").equals("");
    }
}
