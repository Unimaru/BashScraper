package pl.tb.extraction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MockReceiver extends Receiver {
    public MockReceiver(String request) {
        super(request);
    }

    @Override
    Document getDocument() {
        return MockPageChooser.choosePage(request).getContent();
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
