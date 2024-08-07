package com.homework.exam;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchMark {

    public static void main(String[] args) throws RunnerException {
        new Runner(new OptionsBuilder()
                .include(Bench.class.getSimpleName())
                .build()).run();
    }
}
