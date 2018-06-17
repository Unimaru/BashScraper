package pl.tb.extraction;

import org.jsoup.Jsoup;

public enum MockPage {

    FIRST_PAGE(MockPageContent.firstPage, "test/?page=2"), SECOND_PAGE(MockPageContent.secoundPage, "test/?page=3"), LAST_PAGE(MockPageContent.lastPage, null);

    private Page page;

    MockPage(String content, String nextPage) {
        this.page = new Page(Jsoup.parse(content), nextPage);
    }

    public Page getPage() {
        return page;
    }
}
