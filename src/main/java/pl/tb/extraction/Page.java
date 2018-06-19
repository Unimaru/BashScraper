package pl.tb.extraction;


import org.jsoup.nodes.Document;

import java.util.Objects;

public class Page {

    private final Document content;
    private final String nextPage;

    public Page(Document content, String nextPage) {
        this.content = content;
        this.nextPage = nextPage;
    }

    public Document getContent() {
        return content;
    }

    public String getNextPage() {
        return nextPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return Objects.equals(content, page.content) &&
                Objects.equals(nextPage, page.nextPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, nextPage);
    }
}
