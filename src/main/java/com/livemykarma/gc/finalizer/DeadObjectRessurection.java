package com.livemykarma.gc.finalizer;

public class DeadObjectRessurection {
	static DeadObjectRessurection sObject;
	
	String message = "DeadObjectRessurection";

	@Override
	protected void finalize() throws Throwable {
		sObject = this;
	}
}
