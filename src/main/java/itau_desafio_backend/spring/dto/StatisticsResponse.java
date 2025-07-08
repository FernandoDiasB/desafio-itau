package itau_desafio_backend.spring.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticsResponse {

    private final long count;
    private final double sum;
    private final double avg;
    private final double min;
    private final double max;

    public StatisticsResponse(DoubleSummaryStatistics stats) {
        this.avg = stats.getAverage();
        this.count = stats.getCount();
        this.max = stats.getMax();
        this.min = stats.getMin();
        this.sum = stats.getSum();
    }

    public long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

}
