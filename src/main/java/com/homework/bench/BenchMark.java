package com.homework.bench;

import java.awt.BorderLayout;
import java.util.Collection;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;

import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchMark {

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(Bench.class.getSimpleName())
                .forks(1)
                .build();

        Collection<RunResult> runResults = new Runner(options).run();

        JFrame frame = new JFrame("Benchmark Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("Benchmark");
        model.addColumn("Mode");
        model.addColumn("Score");
        model.addColumn("Unit");

        for (RunResult result : runResults) {
            Result<?> r = result.getPrimaryResult();
            model.addRow(new Object[]{r.getLabel(), r.getStatistics(), r.getScore(), r.getScoreUnit()});
        }

        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

