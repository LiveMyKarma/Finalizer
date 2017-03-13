package com.livemykarma.gc.finalizer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Problem class
 * 
 * @author Gautam
 *
 */
public class OutputStreamWrapper {
	private OutputStream stream;

	public OutputStreamWrapper() {
		try {
			stream = new FileOutputStream("filePath");
		} catch (FileNotFoundException e) {
		}
	}
	
	public void write(byte[] bytes) throws IOException {
		stream.flush();
		stream.write(bytes);
	}

	@Override
	protected void finalize() throws Throwable {
		stream.close();
	}
}
