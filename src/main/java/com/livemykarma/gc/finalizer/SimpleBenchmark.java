package com.livemykarma.gc.finalizer;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class SimpleBenchmark {

	@Benchmark
	public NonFinalizableClass testNonFinalizable() {
		Blackhole.consumeCPU(5);
		return new NonFinalizableClass();
	}

	@Benchmark
	public FinalizableClass testFinalizable() {
		Blackhole.consumeCPU(5);
		return new FinalizableClass();
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(SimpleBenchmark.class.getSimpleName())
				.threads(4)
				.forks(1)
				.measurementIterations(50)
				.warmupIterations(50)
				.addProfiler(GCProfiler.class)
				.build();

		new Runner(opt).run();
	}

}
