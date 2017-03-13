package com.livemykarma.gc.finalizer;

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
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 10, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 50, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Fork(4)
public class BenchmarkWithGCProfiler {
	@Param({ "1", "2", "3", "5", "8", "13", "21", "34", "55", "89", "144", 
			"233", "377", "610", "987", "1597", "2584", "4181", "6765"})
	private int tokens;

	
	@Benchmark
	public NonFinalizableClass testNonFinalizable() {
		 Blackhole.consumeCPU(tokens);
		 return new NonFinalizableClass();
	}
	
	@Benchmark
	public FinalizableClass testFinalizable() {
		 Blackhole.consumeCPU(tokens);
		 return new FinalizableClass();
	}
	
	public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkWithGCProfiler.class.getSimpleName())
                .addProfiler(GCProfiler.class)
                .threads(4)
                .build();

        new Runner(opt).run();
	}

}
