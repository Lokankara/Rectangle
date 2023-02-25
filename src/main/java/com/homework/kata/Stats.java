package main.java.com.homework.kata;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Stream;

public class Stats {

    public static double[][] getMinAvgMax(int discard, double[]... data) {

        double[][] result = new double[data.length+1][3];

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double count = 0;
        double sum = 0;
        DoubleSummaryStatistics stats;

        for (int i = 0; i < data.length; i++) {
            stats = Arrays.stream(Arrays.copyOfRange(data[i], discard, data[i].length - discard)).summaryStatistics();

            result[i][1] = stats.getAverage();
            result[i][0] = stats.getMin();
            result[i][2] = stats.getMax();

            min = Math.min(min, result[i][0]);
            max = Math.max(max, result[i][2]);
            count += stats.getCount();
            sum += stats.getSum();

        }

        result[result.length - 1][0] = min;
        result[result.length - 1][1] = sum / count;
        result[result.length - 1][2] = max;
        return result;
    }
    public static double[][] findMinAvgMax(int discard, double[][] data) {
        DoubleSummaryStatistics total = new DoubleSummaryStatistics();

        Stream<DoubleSummaryStatistics> stats = Arrays.stream(data)
                .map(a -> Arrays.stream(a)
                        .limit(a.length - discard)
                        .skip(discard).summaryStatistics())
                .peek(total::combine);

        return
                Stream.concat(stats, Stream.of(total))
                        .map(s -> new double[]{s.getMin(), s.getAverage(), s.getMax()})
                        .toArray(double[][]::new);
    }

}
