package com.livemykarma.gc.finalizer;

import java.io.InputStream;
import java.util.HashMap;

/**
 * Finalizable class with big map. Should be normalized. 
 * 
 * @author Gautam
 *
 */
public class HeavyFinalizable {
	HashMap<String, String> bigHashMap;
	InputStream stream;
	
	@Override
	protected void finalize() throws Throwable {
		stream.close();
	}
}
