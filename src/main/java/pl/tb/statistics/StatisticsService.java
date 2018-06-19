package pl.tb.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsService {

    private Map<String, List<StatisticsData>> namedStatistics = new HashMap<>();

    public void addToNamedStatistics(String name, List<StatisticsData> statisticsData) {
        namedStatistics.put(name, statisticsData);
    }

    public String getStatistics() {
        StatisticsCounter statisticsCounter = new StatisticsCounter();
        List<StatisticResult> results = statisticsCounter.getResults(namedStatistics.entrySet());
        return preparePrettyData(results);
    }

    private String preparePrettyData(List<StatisticResult> results) {
        StringBuilder stringBuilder = new StringBuilder();
        results.forEach(statisticResult -> stringBuilder.append("\n" + statisticResult.getName() + " was processed in average time of " + statisticResult.getAverageTime() + " ms."));
        return stringBuilder.toString();
    }

}
