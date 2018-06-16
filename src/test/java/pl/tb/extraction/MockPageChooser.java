package pl.tb.extraction;

import java.util.List;

public class MockPageChooser {

    static String choosePage(String request) {

        if (request.equals("test/")) {
            return MockPage.firstPage;
        }
        if (request.equals("test/?page=2")) {
            return MockPage.secoundPage;
        }
        return MockPage.lastPage;
    }
}
