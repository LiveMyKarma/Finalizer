package com.livemykarma.gc.finalizer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamWrapper {
	private OutputStream stream;

	public OutputStreamWrapper() {
		try {
			stream = new FileOutputStream("filePath");
		} catch (FileNotFoundException e) {
		}
	}
	
	public void write() throws IOException {
		this.stream.flush();
		this.stream.close();
	}

	@Override
	protected void finalize() throws Throwable {
		stream.close();
	}
}
