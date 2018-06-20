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

        checkLimit(limit);

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

    private void checkLimit(Long limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit is smaller then 0");
        }
    }

}
