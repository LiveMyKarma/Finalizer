package com.livemykarma.gc.finalizer;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Fork(4)
public class SimpleBenchmark {

	@Benchmark
	public NonFinalizableClass testNonFinalizable() {
		 return new NonFinalizableClass();
	}

	@Benchmark
	public FinalizableClass testFinalizable() {
		 return new FinalizableClass();
	}
	
	public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SimpleBenchmark.class.getSimpleName())
                .forks(4)
                .threads(40)
                .build();

        new Runner(opt).run();
	}

}
