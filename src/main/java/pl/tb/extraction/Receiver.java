package pl.tb.extraction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public abstract class Receiver {

    String request;

    public Receiver(String request) {
        this.request = request;
    }

    public String getRequest() {
        return request;
    }

    public Page receiveData() {
        Document document = getDocument();
        return new Page(document, returnNextPageIfExist(document));
    }

    abstract Document getDocument();

    abstract String generateNewRequest(Document document);

    abstract String returnNextPageIfExist(Document document);

    abstract boolean hasNextPage(Document document);

}
