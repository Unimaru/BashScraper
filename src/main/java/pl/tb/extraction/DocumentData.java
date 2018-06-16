package pl.tb.extraction;

import org.jsoup.nodes.Document;

public class DocumentData {

    private final Document document;
    private final Boolean hasNextPage;
    private final String nextPageRequest;

    public DocumentData(Document document, Boolean hasNextPage, String nextPageRequest) {
        this.document = document;
        this.hasNextPage = hasNextPage;
        this.nextPageRequest = nextPageRequest;
    }

    public Document getDocument() {
        return document;
    }

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public String getNextPageRequest() {
        return nextPageRequest;
    }
}
