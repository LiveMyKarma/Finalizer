package com.livemykarma.gc.finalizer;

import org.openjdk.jmh.runner.RunnerException;

public class SimpleBenchmark {

	public long benchMarkNonFinalizable() {
		long nonFinalizableTime = 0;
		for (int i = 0; i < 1000000; i++) {
			long startTime = System.nanoTime();
			System.out.println(new NonFinalizableClass().message);
			nonFinalizableTime = nonFinalizableTime + (System.nanoTime() - startTime);
		}
		
		return nonFinalizableTime;
	}
	
	public long benchMarkFinalizable() {
		long finalizableTime = 0;
		for (int i = 0; i < 1000000; i++) {
			long startTime = System.nanoTime();
			System.out.println(new FinalizableClass().message);
			finalizableTime = finalizableTime + (System.nanoTime() - startTime);
		}
		
		return finalizableTime;
	}

	public static void main(String[] args) throws RunnerException {
		SimpleBenchmark benchmark = new SimpleBenchmark();
		
		long nonFinalizableTime = benchmark.benchMarkNonFinalizable();
		long finalizableTime = benchmark.benchMarkFinalizable();
		System.out.println("nonFinalizableTime = " + nonFinalizableTime);
		System.out.println("finalizableTime = " + finalizableTime);
	}

}
