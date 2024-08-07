package com.homework.bench;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = {"-Xms512m", "-Xmx512m"})
@Warmup(iterations = 2, time = 200, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Timeout(time = 1, timeUnit = TimeUnit.MINUTES)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Bench {

    final String firstString_1 = "I originally approached Java as just another programming language. But as time passed and I studied it more deeply.";
    final String secondString_1 = "Because of this complexity most of our programming projects fail. And yet of all.";
    final String firstString_2 = "I originally approached Java as just another programming language. But as time passed and I studied it more deeply. " +
            "I began to see that the fundamental intent of this language was different from other languages I had seen up to that point. ";
    final String secondString_2 = "Because of this complexity most of our programming projects fail. And yet of all " +
            "the programming languages of which I am aware. Almost none have gone all out " +
            "and decided that their main design goal would be to conquer the complexity of " +
            "developing and maintaining programs. Many language design decisions were made ";

    @Param({firstString_1, firstString_2})
    String a;
    @Param({secondString_1, secondString_2})
    String b;

    @Benchmark
    public void testForFirstDesign(Blackhole bh) {
        for (int i = 0; i < 100_000; i++) {
            bh.consume(Slicer.concat(a, b));
        }


    }

    @Benchmark
    public void testForSecondDesign(Blackhole bh) {
        for (int i = 0; i < 100_000; i++) {
            bh.consume(Design.concat(a, b));
        }
    }

    @Benchmark
    public void testCharArrayConcatDesign(Blackhole bh) {
        for (int i = 0; i < 100_000; i++) {
            bh.consume(CharArrayConcat .concat(a, b));
        }
    }
    @Benchmark
    public void testPlusOperatorConcatDesign(Blackhole bh) {
        for (int i = 0; i < 100_000; i++) {
            bh.consume(BufferConcat.concat(a, b));
        }
    }
    @Benchmark
    public void testForMyFirstDesign(Blackhole bh) {
        for (int i = 0; i < 100_000; i++) {
            bh.consume(BuilderDesign.concat(a, b));
        }
    }
}
