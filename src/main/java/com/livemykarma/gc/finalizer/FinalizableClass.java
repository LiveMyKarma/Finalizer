package com.livemykarma.gc.finalizer;

import java.io.InputStream;

public class FinalizableClass {
	String message;
	InputStream stream;
	
	@Override
	protected void finalize() throws Throwable {
		stream.close(); //This can be avoided by restructuring your class, 
						//or utilizing object life cycle methods 
	}
}
