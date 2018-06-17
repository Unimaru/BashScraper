package pl.tb.extraction;

import java.util.List;

public interface PageLoader {

    List<Page> loadPagesLimitedTo(Long limit, Receiver receiver);
}
