package com.livemykarma.gc.finalizer;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

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
                .threads(40)
                .build();

        new Runner(opt).run();
	}

}
