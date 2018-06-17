package pl.tb.extraction;

import java.util.Arrays;
import java.util.List;

public class MockPageChooser {

    static Page choosePage(String request) {

        if (request.equals("test/")) {
            return MockPage.FIRST_PAGE.getPage();
        }
        if (request.equals("test/?page=2")) {
            return MockPage.SECOND_PAGE.getPage();
        }
        return MockPage.LAST_PAGE.getPage();
    }

    static List<Page> obtainAllPages() {
        return Arrays.asList(MockPage.FIRST_PAGE.getPage(), MockPage.SECOND_PAGE.getPage(), MockPage.LAST_PAGE.getPage());
    }
}
