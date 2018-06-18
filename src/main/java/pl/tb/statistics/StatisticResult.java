package pl.tb.statistics;

public class StatisticResult {

    private String name;
    private Long averageTime;

    public StatisticResult(String name, Long averageTime) {
        this.name = name;
        this.averageTime = averageTime;
    }

    public String getName() {
        return name;
    }

    public Long getAverageTime() {
        return averageTime;
    }

    @Override
    public String toString() {
        return "StatisticResult{" +
                "name='" + name + '\'' +
                ", averageTime=" + averageTime +
                '}';
    }
}
