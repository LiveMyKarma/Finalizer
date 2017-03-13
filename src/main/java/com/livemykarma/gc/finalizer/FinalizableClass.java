package com.livemykarma.gc.finalizer;

public class FinalizableClass {
	String message = "FinalizableClass";
	int counter = 100;
	
	@Override
	protected void finalize() throws Throwable {
		counter = 0;
		message = null;
	}
}
