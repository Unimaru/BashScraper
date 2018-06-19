package pl.tb.extraction;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class WebPageLoaderTest {

    private PageLoader instance;
    private String request;

    @Before
    public void setUp() {
        request = "test/";
        instance = new WebPageLoader(new MockReceiver(request));
    }

    @Test
    public void downloadPagesWithLimitSetOnOne() {
        //given
        List<Page> expectedPages = Arrays.asList(MockPageChooser.choosePage(request));
        //when
        List<Page> pages = instance.loadPagesLimitedTo(1L);
        //then
        assertIsNumberOfPagesCorrect(1L, Long.valueOf(pages.size()));
        assertIfPagesContentIsCorrect(expectedPages, pages);
    }

    @Test
    public void downloadPagesWithLimitSetOnMaxCountOfPages() {
        //given
        List<Page> expectedPages = MockPageChooser.obtainAllPages();
        Long limit = 3L;
        //when
        List<Page> pages = instance.loadPagesLimitedTo(limit);
        //then
        assertIsNumberOfPagesCorrect(limit, Long.valueOf(pages.size()));
        assertIfPagesContentIsCorrect(expectedPages, pages);
    }

    @Test
    public void downloadPagesWithLimitBiggerThenNumberOfPages() {
        //given
        List<Page> expectedPages = MockPageChooser.obtainAllPages();
        Long limit = 10L;
        //when
        List<Page> pages = instance.loadPagesLimitedTo(limit);
        //then
        assertIsNumberOfPagesCorrect(3L, Long.valueOf(pages.size()));
        assertIfPagesContentIsCorrect(expectedPages, pages);
    }

    @Test
    public void downloadPageWithZeroLimit() {
        //given
        List<Page> expectedPages = Arrays.asList();
        Long limit = 0L;
        //when
        List<Page> pages = instance.loadPagesLimitedTo(limit);
        //then
        assertIsNumberOfPagesCorrect(0L, Long.valueOf(pages.size()));
        assertIfPagesContentIsCorrect(expectedPages, pages);
    }

    private void assertIfPagesContentIsCorrect(List<Page> expectedPages, List<Page> pages) {
        assertArrayEquals(expectedPages.stream().map(data -> data.getContent().toString()).toArray()
                , pages.stream().map(page -> page.getContent().toString()).toArray());
    }

    private void assertIsNumberOfPagesCorrect(Long expectedNumberOfPages, Long currentNumberOfPages) {
        assertEquals(expectedNumberOfPages, currentNumberOfPages);
    }

}