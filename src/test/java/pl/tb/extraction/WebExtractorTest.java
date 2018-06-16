package pl.tb.extraction;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class WebExtractorTest {

    WebExtractor instance;
    MockDocumentRetriever mockDocumentRetriever;

    @Before
    public void setUp() {
        instance = new WebExtractor();
        mockDocumentRetriever = new MockDocumentRetriever();
    }

    @Test
    public void assertIfAllPagesAreLoaded() {
        //given
        List<WebData> mockData = createMockDataForAllPages();
        //when
        List<WebData> webData = instance.extractDataFrom(mockDocumentRetriever, "test/");
        //then
        assertEquals(mockData, webData);
    }

    private List<WebData> createMockDataForAllPages() {
        List<WebData> mockData = new LinkedList<>();
        mockData.add(new WebData(1L, 5L, "Test text"));
        mockData.add(new WebData(2L, 10L, "test text 2"));
        mockData.add(new WebData(3L, 5L, "Test text on page 2"));
        mockData.add(new WebData(4L, 10L, "next test text on page 2"));
        mockData.add(new WebData(5L, 15L, "Test text on last page"));

        return mockData;
    }
}
