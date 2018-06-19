package pl.tb.extraction;

import java.util.ArrayList;
import java.util.List;

public class WebPageLoader implements PageLoader {

    private final Receiver receiver;

    public WebPageLoader(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public List<Page> loadPagesLimitedTo(Long limit) {

        List<Page> pages = new ArrayList<>();
        String request = receiver.getRequest();

        for (int index = 0; index < limit; index++) {
            if (request != null) {
                Page page = receiver.receiveData();
                request = page.getNextPage();
                pages.add(page);
            } else {
                break;
            }
        }

        return pages;
    }

}
