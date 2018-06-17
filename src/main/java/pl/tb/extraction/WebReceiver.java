package pl.tb.extraction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class WebReceiver extends Receiver {


    public WebReceiver(String request) {
        super(request);
    }

    Document getDocument() {
        try {
            return Jsoup.parse(new URL(request), 5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    String generateNewRequest(Document document) {
        request = request.replaceAll("(\\?.*)", "").concat(document.body().getElementsByClass("next").attr("href"));
        return request;
    }

    String returnNextPageIfExist(Document document) {
        if (hasNextPage(document)) {
            return generateNewRequest(document);
        }
        return null;
    }

    boolean hasNextPage(Document document) {
        return !document.body().getElementsByClass("next").attr("href").equals("");
    }

}
