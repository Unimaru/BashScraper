package pl.tb.statistics;

public class StatisticsData {

    private Long startTime;
    private Long endTime;

    public StatisticsData(Long startTime, Long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getPeriod() {
        return endTime - startTime;
    }
}
