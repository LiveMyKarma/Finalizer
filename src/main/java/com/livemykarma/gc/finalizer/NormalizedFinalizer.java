package com.livemykarma.gc.finalizer;

import java.io.InputStream;
import java.util.HashMap;


public class NormalizedFinalizer {
	HashMap<String, String> bigHashMap;
	InputStream stream;
	Object finalizer = new Object() {
		protected void finalize() throws Throwable {
			stream.close();
		};
	};
}
