package com.livemykarma.gc.finalizer;

public class FinalizableClass {
	int counter = 100;
	String message = "Testing...";
	
	@Override
	protected void finalize() throws Throwable {
		counter = 0;
		message = null;
	}
}
