package com.livemykarma.gc.finalizer;

import java.io.InputStream;

/**
 * Class with explicit cleanup method
 * 
 * @author Gautam
 *
 */
public class ClosableForFinalizer implements AutoCloseable {
	InputStream stream;
	
	@Override
	public void close() throws Exception {
		stream.close();
	}
 
}
