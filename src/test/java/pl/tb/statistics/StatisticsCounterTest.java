package pl.tb.statistics;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class StatisticsCounterTest {

    private StatisticsCounter instance;

    @Before
    public void setUp() {
        instance = new StatisticsCounter();
    }

    @Test
    public void calculateDataForCorrectList() {
        //given
        String name = "Test";
        Map<String, List<StatisticsData>> data = new HashMap<>();
        data.put(name, createStatisticsData());
        //when
        List<StatisticResult> results = instance.getResults(data.entrySet());
        //then
        assertEquals(new Long(4L), results.get(0).getAverageTime());
    }

    @Test
    public void calculateDataForEmptyList() {
        //given
        String name = "Test";
        Map<String, List<StatisticsData>> data = new HashMap<>();
        data.put(name, new ArrayList<>());
        //when
        List<StatisticResult> results = instance.getResults(data.entrySet());
        //then
        assertEquals(new Long(0L), results.get(0).getAverageTime());
    }

    private List<StatisticsData> createStatisticsData() {
        return Arrays.asList(new StatisticsData(10L, 15L), new StatisticsData(10L, 15L), new StatisticsData(8L, 12L));
    }
}