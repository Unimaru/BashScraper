package pl.tb.statistics;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleToLongFunction;
import java.util.stream.Collectors;

public class StatisticsCounter {

    public List<StatisticResult> getResults(Set<Map.Entry<String, List<StatisticsData>>> dataToCalculate) {
        return dataToCalculate.stream().map(entryList -> new StatisticResult(entryList.getKey(),
                ((DoubleToLongFunction) data -> {
                    Double result = data;
                    return result.longValue();
                }).applyAsLong(entryList
                        .getValue()
                        .stream()
                        .mapToDouble(value -> value
                                .getPeriod()
                                .doubleValue())
                        .average()
                        .orElse(0.0))
        )).collect(Collectors.toList());
    }
}
